package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.alexandra_incr.authorssupervision.config.SecurityUtils
import ru.alexandra_incr.authorssupervision.service.UserService

@RestController
@RequestMapping("account")
@SecurityRequirement(name = "jwt")
class AccountController(
    private val userService: UserService,
    private val securityUtils: SecurityUtils
) {

    @PutMapping("change-password")
    @Operation(
        summary = "Смена пароля",
        tags = ["account"]
    )
    fun changePassword(@RequestParam("new-password") password:String){
        val id = securityUtils.getID()
        if(id != null)
            userService.changePassword(id,password)
    }
}