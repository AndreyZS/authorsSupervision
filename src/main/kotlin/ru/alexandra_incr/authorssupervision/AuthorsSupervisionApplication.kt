package ru.alexandra_incr.authorssupervision

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType
import io.swagger.v3.oas.annotations.security.SecurityScheme
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@SecurityScheme(
    name = "jwt", type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
@EnableScheduling
class AuthorsSupervisionApplication

fun main(args: Array<String>) {
    runApplication<AuthorsSupervisionApplication>(*args)
}
