package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.ListEspeciallyDangerousWork
import org.jooq.generated.tables.ListEspeciallyDangerousWork.*
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.controller.StatusCheck
import ru.alexandra_incr.authorssupervision.dto.OORDto
import ru.alexandra_incr.authorssupervision.dto.UserSystem
import ru.alexandra_incr.authorssupervision.dto.WorkPlan
import ru.alexandra_incr.authorssupervision.service.crud.set

@Service
class OORService(
    private val dslContext: DSLContext,
    private val workPlanService: WorkPlanService,
    private val singDangerService: SingDangerService,
    private val addressService: AddressService
) {

    fun create(oor: OORDto,workPlan: WorkPlan,userSystemId:Long){
        val workPlanID = workPlanService.create(workPlan)
        val alg:(org.jooq.Record)->Long = {res-> res.get(LIST_ESPECIALLY_DANGEROUS_WORK.ID)}
        LIST_ESPECIALLY_DANGEROUS_WORK.set(dslContext,alg,
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.NAME,oor.name),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.DATE_START,oor.dateStart),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.DATE_STOP,oor.dateStop),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.LOCATION_ID,addressService.getOrCreatAddress(oor.address).locationID),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.EMPLOYEE_ID,userSystemId),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.SIGN_DANGER_ID,singDangerService.findOrCreate(oor.singDanger)),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.WORK_PLAN_ID,workPlanID)
        )
    }

    fun update(oorId:Long,status:StatusCheck,userSystemId: Long){
        dslContext.update(LIST_ESPECIALLY_DANGEROUS_WORK)
            .set(LIST_ESPECIALLY_DANGEROUS_WORK.CHIEF_ENGINEER,userSystemId)
            .set(LIST_ESPECIALLY_DANGEROUS_WORK.DATECHECK,status.date)
            .where(LIST_ESPECIALLY_DANGEROUS_WORK.ID.eq(oorId))
            .execute()
    }
}