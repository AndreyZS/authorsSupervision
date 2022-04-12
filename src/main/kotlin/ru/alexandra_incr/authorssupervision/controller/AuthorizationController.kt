package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.alexandra_incr.authorssupervision.dto.JwtAndStatus
import ru.alexandra_incr.authorssupervision.dto.RegistrationDTO
import ru.alexandra_incr.authorssupervision.service.AuthenticationService
import ru.alexandra_incr.authorssupervision.service.UserService

@RestController
@RequestMapping("auth")
@Transactional
class AuthorizationController(
    private val userService: UserService,
    private val authenticationService: AuthenticationService
) {


    @GetMapping("login")
    @Operation(
        summary = "Авторизация",
        description = "Принимает логин и пароль, если они верны возвращает токен",
        tags = ["account"]
    )
    fun auth(@RequestParam("login") login:String,@RequestParam("password") password:String): JwtAndStatus {
       return authenticationService.authorization(login,password).apply {
           println(this)
       }
    }

    @PostMapping("registration")
    @Operation(
        summary = "Регистрация",
        tags = ["account"]
    )
    fun registration(@RequestBody registrationData: RegistrationDTO){
        userService.registration(registrationData.login,registrationData.password,registrationData.roles)
    }

    @GetMapping("admin")
    @Operation()
    @SecurityRequirement(name = "jwt")
    fun test(): String {
        return "Ты смог"
    }
}