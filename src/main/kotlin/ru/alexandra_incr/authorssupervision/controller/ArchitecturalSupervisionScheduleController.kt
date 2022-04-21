package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.alexandra_incr.authorssupervision.config.SecurityUtils
import ru.alexandra_incr.authorssupervision.dto.ArchitecturalSupervision
import ru.alexandra_incr.authorssupervision.service.ArchitecturalSupervisionScheduleService

@RestController
@RequestMapping("architectural-supervision-schedule")
@SecurityRequirement(name = "jwt")
class ArchitecturalSupervisionScheduleController(
    private val assService:ArchitecturalSupervisionScheduleService,
    private val securityUtils: SecurityUtils
) {

    @PostMapping("employee/create")
    fun create(@RequestBody dto: ArchitecturalSupervision,@RequestParam oooID:Long,@RequestParam employeeId:Long){
        assService.create(dto,employeeId,oooID)
    }

    @PutMapping("engineer/check")
    fun checkEngineer(@RequestBody dto:StatusCheck, @RequestParam assId:Long){
        assService.checkEngineer(assId,dto,securityUtils.getID()!!)
    }

    @GetMapping("signature")
    fun signature(@RequestParam assId: Long){
        assService.signature(assId,securityUtils.getID()!!)
    }

    @GetMapping("employee/signature")
    fun signatureEmployee(@RequestParam assId: Long){
        assService.signatureEmployee(assId,securityUtils.getID()!!)
    }

}