package ru.alexandra_incr.authorssupervision.dto

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDate

sealed interface UserSystem

class AuthorizedUser(val id: Long, val login: String, val listRoles: List<GrantedAuthority>,val dateChangePassword:LocalDate?) :
    UserSystem, UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listRoles
    }

    override fun getPassword(): String {
        return "_!_"
    }


    override fun getUsername(): String {
        return login
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}

object Anonymous : UserSystem, UserDetails {
    override fun getAuthorities(): List<GrantedAuthority> = listOf()

    override fun getPassword(): String  = ""

    override fun getUsername(): String = "anonymous"

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean =true

    override fun isCredentialsNonExpired(): Boolean =true

    override fun isEnabled(): Boolean =true
}