package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.WorkPlan.*
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.dto.RequestWorkPlan
import ru.alexandra_incr.authorssupervision.dto.WorkPlan
import ru.alexandra_incr.authorssupervision.service.crud.get
import ru.alexandra_incr.authorssupervision.service.crud.set

@Service
class WorkPlanService(
    private val dslContext: DSLContext,
) {

    fun create(workPlan: WorkPlan): Long {
        val alg: (org.jooq.Record) -> (Long) = { res -> res.get(WORK_PLAN.ID) }
        return WORK_PLAN.set(dslContext,
            alg,
            Pair(WORK_PLAN.NAME, workPlan.name),
            Pair(WORK_PLAN.ABOUTUPDATE, workPlan.aboutUpdate),
            Pair(WORK_PLAN.DATEUPDATE, workPlan.dateUpdate)
        )
    }

    fun update(workPlan: RequestWorkPlan){
        dslContext.update(WORK_PLAN)
            .set(WORK_PLAN.ABOUTUPDATE,workPlan.aboutUpdate)
            .set(WORK_PLAN.DATEUPDATE,workPlan.dateUpdate)
            .where(WORK_PLAN.ID.eq(workPlan.id))
    }
}