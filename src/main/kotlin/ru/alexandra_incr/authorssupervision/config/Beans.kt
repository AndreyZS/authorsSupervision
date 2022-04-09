package ru.alexandra_incr.authorssupervision.config

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Component
class Beans {

    @Bean
    fun bCrypt(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource? {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("/*")
        configuration.allowedMethods = listOf("*")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("*", configuration)
        return source
    }
}