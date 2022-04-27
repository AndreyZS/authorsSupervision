package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.ArchitecturalSupervisionRegister.ARCHITECTURAL_SUPERVISION_REGISTER
import org.jooq.generated.tables.CopyrightSupervisionReport.COPYRIGHT_SUPERVISION_REPORT
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.controller.StatusCheck
import ru.alexandra_incr.authorssupervision.dto.ArchitecturalSupervisionRegisterDto
import ru.alexandra_incr.authorssupervision.service.crud.set
import ru.alexandra_incr.authorssupervision.service.init.Document

@Service
class ArchitecturalSupervisionRegisterService(
    private val dslContext: DSLContext,
) : Document<ArchitecturalSupervisionRegisterDto> {

    override fun create(dto: ArchitecturalSupervisionRegisterDto, idPrevious: Long, userSystemId: Long) {
        val alg: (org.jooq.Record) -> (Long) = { res -> res.get(ARCHITECTURAL_SUPERVISION_REGISTER.ID) }
        val employeeWork = COPYRIGHT_SUPERVISION_REPORT.findByOne(dslContext)(COPYRIGHT_SUPERVISION_REPORT.ID.eq(idPrevious)
            .and(COPYRIGHT_SUPERVISION_REPORT.EMPLOYEE_ID.eq(userSystemId))).get(COPYRIGHT_SUPERVISION_REPORT.ID)
        if (employeeWork != null) {
            ARCHITECTURAL_SUPERVISION_REGISTER.set(dslContext, alg,
                Pair(ARCHITECTURAL_SUPERVISION_REGISTER.ID, idPrevious),
                Pair(ARCHITECTURAL_SUPERVISION_REGISTER.EMPLOYEE_ID, userSystemId),
                Pair(ARCHITECTURAL_SUPERVISION_REGISTER.ACTUAL_VERIFICATION_DATE, dto.actualVerificationDate),
                Pair(ARCHITECTURAL_SUPERVISION_REGISTER.ACCORDING_SHIFT, dto.accordingShift),
                Pair(ARCHITECTURAL_SUPERVISION_REGISTER.ACCORDING_SCHEDULE_DATE, dto.accordingScheduleDate),
                Pair(ARCHITECTURAL_SUPERVISION_REGISTER.ACTUAL_VERIFICATION_SHIFT, dto.actualVerificationShift),
                Pair(ARCHITECTURAL_SUPERVISION_REGISTER.IDENTIFIED_INCONSISTENCIES, dto.identifiedInconsistencies),
                Pair(ARCHITECTURAL_SUPERVISION_REGISTER.REASONS_NONCOMPLIANCE, dto.reasonsNoncompliance)
            )
        }
    }

//    fun update(dto: ArchitecturalSupervisionRegisterDto, idPrevious: Long, userSystemId: Long) {
//        val t = COPYRIGHT_SUPERVISION_REPORT.findByOne(dslContext)(COPYRIGHT_SUPERVISION_REPORT.ID.eq(idPrevious)
//            .and(COPYRIGHT_SUPERVISION_REPORT.EMPLOYEE_ID.eq(userSystemId))).get(COPYRIGHT_SUPERVISION_REPORT.ID)
//        if (t != null) {
//            dslContext.update(COPYRIGHT_SUPERVISION_REPORT)
//                .set()
//        }
//    }

    override fun checkEngineer(documentId: Long, status: StatusCheck, userSystemId: Long) {
        dslContext.update(ARCHITECTURAL_SUPERVISION_REGISTER)
            .set(ARCHITECTURAL_SUPERVISION_REGISTER.DATECHECK, status.date)
            .set(ARCHITECTURAL_SUPERVISION_REGISTER.CHIEF_ENGINEER, userSystemId)
            .where(ARCHITECTURAL_SUPERVISION_REGISTER.ID.eq(documentId))
            .execute()
    }

    override fun urgently(oorId: Long): Boolean {
        return ARCHITECTURAL_SUPERVISION_REGISTER.findByOne(dslContext)(ARCHITECTURAL_SUPERVISION_REGISTER.ID.eq(oorId)
            .and(ARCHITECTURAL_SUPERVISION_REGISTER.DATECHECK.isNotNull)).get(ARCHITECTURAL_SUPERVISION_REGISTER.ID)
            ?.let { true } ?: false
    }

}