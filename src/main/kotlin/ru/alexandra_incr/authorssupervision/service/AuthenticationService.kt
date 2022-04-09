package ru.alexandra_incr.authorssupervision.service

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import org.springframework.web.filter.GenericFilterBean
import ru.alexandra_incr.authorssupervision.dto.AuthorizedUser
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

@Service
@PropertySource("classpath:secret.properties")
class AuthenticationService(
    private val userService: UserService,
    @Value("\${secret_word}")
    private var secret: String,
    @Value("\${issuer}")
    private var issuer: String,
    @Value("\${time_live_jwt}")
    private var timeLife: String,
) : GenericFilterBean() {

    private val algorithm: Algorithm by lazy { Algorithm.HMAC256(secret) }

    fun authorization(login: String, password: String) =
        when (val data = userService.getUserByLoginAndPassword(login, password)) {
            is AuthorizedUser -> createJWT(data)
            else -> throw Exception("вы не авторизованы")
        }


    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val token = getTokenFromRequest(request as (HttpServletRequest))
        if (token != null) {
            SecurityContextHolder.getContext().authentication = authentication(token)
        }
        chain?.doFilter(request, response)
    }

    private fun createJWT(payload: AuthorizedUser): String {
        val date = Calendar.getInstance()
        date.add(Calendar.MINUTE, timeLife.toInt())
        return JWT.create()
            .withIssuedAt(Calendar.getInstance().time)
            .withExpiresAt(date.time)
            .withIssuer(issuer)
            .withClaim("id", payload.id)
            .withClaim("login", payload.login)
            .withArrayClaim("roles", payload.listRoles.map { it.authority }.toTypedArray())
            .sign(algorithm)
    }

    private fun authentication(token: String): Authentication {
        val verifier: JWTVerifier = JWT.require(algorithm)
            .withIssuer(issuer)
            .build()
        try {
            val jwt: DecodedJWT = verifier.verify(token)
            val userDetails = AuthorizedUser(
                id = jwt.claims["id"]!!.asLong(),
                login = jwt.claims["login"]!!.asString(),
                listRoles = jwt.claims["roles"]!!.asList(String::class.java).map { SimpleGrantedAuthority(it) }
            )
            return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
        }catch (e:Exception){
            throw Exception("Ваша сессия закончилась")
        }

    }

    private fun getTokenFromRequest(request: HttpServletRequest): String? {
        val bearer = request.getHeader(HttpHeaders.AUTHORIZATION)
        return if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
            bearer.substring(7)
        } else null
    }
}