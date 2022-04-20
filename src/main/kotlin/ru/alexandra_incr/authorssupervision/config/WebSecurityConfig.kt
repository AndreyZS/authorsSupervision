package ru.alexandra_incr.authorssupervision.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import ru.alexandra_incr.authorssupervision.service.AuthenticationService


@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val authService: AuthenticationService,
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.cors()
        http.httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/swagger-ui/**", "/v3/**").permitAll()
            .antMatchers("/img/**", "/favicon.ico").permitAll()
            .antMatchers("/auth/login").permitAll()
            .antMatchers("/auth/registration").permitAll()
            .antMatchers("/role/list").permitAll()
            .antMatchers("/auth/admin").hasRole(Roles.ADMIN.name)
            .antMatchers("/admin/**").hasRole(Roles.ADMIN.name)
            .antMatchers("/oor/create").hasRole(Roles.OOR.name)
            .antMatchers("/oor/check").hasRole(Roles.ChiefEngineer.name)
            .anyRequest().authenticated()
        http.addFilterBefore(authService, UsernamePasswordAuthenticationFilter::class.java)
    }


    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
            "/v3/api-docs",
            "/configuration/ui",
            "/swagger-resources/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
        )
    }
}