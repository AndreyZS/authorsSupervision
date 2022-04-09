package ru.alexandra_incr.authorssupervision.config

import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import ru.alexandra_incr.authorssupervision.dto.Anonymous
import ru.alexandra_incr.authorssupervision.dto.AuthorizedUser

@Component
class SecurityUtils {

    fun getID(): Long? {
        val securityContext: SecurityContext = SecurityContextHolder.getContext()
        return when (val principal = securityContext.authentication.principal) {
            is AuthorizedUser -> principal.id
            is Anonymous -> null
            else -> throw Exception()

        }
    }
}