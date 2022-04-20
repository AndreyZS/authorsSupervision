package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.alexandra_incr.authorssupervision.config.SecurityUtils
import ru.alexandra_incr.authorssupervision.dto.OORDto
import ru.alexandra_incr.authorssupervision.dto.WorkPlan
import ru.alexandra_incr.authorssupervision.service.OORService
import java.time.LocalDateTime

data class OORAndWorkPlan(val oor: OORDto,val workPlan: WorkPlan)
data class StatusCheck(val date:LocalDateTime)

@RestController
@RequestMapping("oor")
@SecurityRequirement(name = "jwt")
class OORController(
    private val oorService: OORService,
    private val securityUtils: SecurityUtils
) {

    @PostMapping("create")
    fun create(@RequestBody oorDto: OORAndWorkPlan){
        //TODO ИСПРАВИТЬ ВИНЖЕНЕРА ПО УМОЛЧАНИЮ
        oorService.create(oorDto.oor,oorDto.workPlan,securityUtils.getID()!!)
    }

    @PutMapping("check")
    fun check(@RequestParam oorID:Long,@RequestBody statusCheck: StatusCheck){
        oorService.update(oorID,statusCheck,securityUtils.getID()!!)
    }
}