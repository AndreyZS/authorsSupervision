package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.*
import ru.alexandra_incr.authorssupervision.config.SecurityUtils
import ru.alexandra_incr.authorssupervision.dto.OOODto
import ru.alexandra_incr.authorssupervision.service.OOOService

@RestController
@RequestMapping("ooo")
@SecurityRequirement(name = "jwt")
class OOOController(
    private val oooService: OOOService,
    private val securityUtils: SecurityUtils
) {

    @PostMapping("create")
    fun create(@RequestBody oooDto: OOODto,@RequestParam oor:Long){
        oooService.create(oooDto,oor,securityUtils.getID()!!)
    }

    @PutMapping("check")
    fun check(@RequestParam oooId:Long, @RequestBody statusCheck: StatusCheck){
        oooService.update(oooId,statusCheck,securityUtils.getID()!!)
    }
}