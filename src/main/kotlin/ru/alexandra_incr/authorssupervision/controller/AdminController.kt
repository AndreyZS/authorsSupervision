package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.alexandra_incr.authorssupervision.dto.Test
import ru.alexandra_incr.authorssupervision.service.AdminService

@RestController
@RequestMapping("admin")
@SecurityRequirement(name = "jwt")
class AdminController(
    private val adminService: AdminService
) {


    @GetMapping("history-passwords")
    fun getListHistoryPasswordUser(): List<Test> {
       return adminService.getListHistoryPassword()
    }
}