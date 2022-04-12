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
import ru.alexandra_incr.authorssupervision.dto.JwtAndStatus
import ru.alexandra_incr.authorssupervision.dto.NewPassword
import ru.alexandra_incr.authorssupervision.dto.StatusPassword
import ru.alexandra_incr.authorssupervision.exceptions.LockedException
import ru.alexandra_incr.authorssupervision.exceptions.PasswordException
import java.time.LocalDate
import java.time.temporal.ChronoUnit
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
            is AuthorizedUser -> {
                if (!data.locked)
                    JwtAndStatus(createJWT(data), StatusPassword(data.dateChangePassword))
                else
                    throw LockedException("пользователь заблокирован")
            }
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
            .withClaim("dateChangePassword", payload.dateChangePassword.toString())
            .withArrayClaim("roles", payload.listRoles.map { it.authority }.toTypedArray())
            .withClaim("locked",payload.locked)
            .sign(algorithm)
    }

    private fun authentication(token: String): Authentication {
        val verifier: JWTVerifier = JWT.require(algorithm)
            .withIssuer(issuer)
            .build()
        try {
            val jwt: DecodedJWT = verifier.verify(token)
            val dateToken = LocalDate.parse(jwt.claims["dateChangePassword"]!!.asString())
            if (checkDateChangePassword(dateToken)) {
                val userDetails = AuthorizedUser(
                    id = jwt.claims["id"]!!.asLong(),
                    login = jwt.claims["login"]!!.asString(),
                    listRoles = jwt.claims["roles"]!!.asList(String::class.java).map { SimpleGrantedAuthority(it) },
                    dateChangePassword = dateToken,
                    locked = jwt.claims["locked"]!!.asBoolean()
                )
                return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
            } else
                throw PasswordException("Смените пароль")
        } catch (e: Exception) {
            throw Exception("Ваша сессия закончилась")
        }
    }

    private fun checkDateChangePassword(date: LocalDate): Boolean {
        val nowDate = LocalDate.now()
        val x = ChronoUnit.DAYS.between(date, nowDate)
        return x<60
    }

    private fun getTokenFromRequest(request: HttpServletRequest): String? {
        val bearer = request.getHeader(HttpHeaders.AUTHORIZATION)
        return if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
            bearer.substring(7)
        } else null
    }
}