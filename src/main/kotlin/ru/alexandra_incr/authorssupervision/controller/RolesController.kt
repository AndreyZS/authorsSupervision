package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.alexandra_incr.authorssupervision.config.Roles

@RestController
@RequestMapping("role")
class RolesController {

    @GetMapping("list")
    @Operation(
        summary = "Список ролей",
        description = "Получить список ролей, доступные для регистрации",
        tags = ["role"]
    )
    fun getRoles(): List<Roles> {
       return Roles.values().filterNot { it==Roles.ADMIN }
    }


}