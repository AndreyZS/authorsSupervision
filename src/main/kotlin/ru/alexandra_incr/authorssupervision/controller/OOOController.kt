package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*
import ru.alexandra_incr.authorssupervision.config.SecurityUtils
import ru.alexandra_incr.authorssupervision.dto.OOODto
import ru.alexandra_incr.authorssupervision.service.OOOService

@RestController
@RequestMapping("list-ooo")
@SecurityRequirement(name = "jwt")
class OOOController(
    private val oooService: OOOService,
    private val securityUtils: SecurityUtils
) {

    @PostMapping("ooo/create")
    @Operation(
        summary = "Создать ООО",
        description = "На основе данных и id ООР создает ООО",
        tags = ["OOO"]
    )
    fun create(@RequestBody oooDto: OOODto,@RequestParam oor:Long,@RequestParam employeeId:Long){
        oooService.create(oooDto,oor,employeeId)
    }

    @PostMapping("ooo/create-urgently")
    @Operation(
        summary = "Создать ООО",
        description = "На основе данных и id ООР создает срочный ООО (альтернативный сценарий)",
        tags = ["OOO"]
    )
    fun urgentlyCreate(@RequestBody oooDto: OOODto,@RequestParam oor:Long){
        oooService.create(oooDto,oor,securityUtils.getID()!!)
    }

    @PutMapping("engineer/check")
    @Operation(
        summary = "Утверждение ООО",
        description = "Утверждение ООО главным инженером",
        tags = ["OOO"]
    )
    fun check(@RequestParam oooId:Long, @RequestBody statusCheck: StatusCheck){
        oooService.update(oooId,statusCheck,securityUtils.getID()!!)
    }
}