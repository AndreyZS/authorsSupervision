package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.generated.tables.ArchitecturalSupervisionSchedule.*
import org.jooq.generated.tables.ArchitecturalSupervisionScheduleSignature.*
import org.jooq.generated.tables.Notes.*
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.controller.StatusCheck
import ru.alexandra_incr.authorssupervision.dto.ArchitecturalSupervision
import ru.alexandra_incr.authorssupervision.exceptions.NotApprovedOOO
import ru.alexandra_incr.authorssupervision.service.crud.set

@Service
class ArchitecturalSupervisionScheduleService(
    private val dslContext: DSLContext,
    private val addressService: AddressService,
    private val oooService: OOOService,
) {

    private val find = ARCHITECTURAL_SUPERVISION_SCHEDULE.findByOne(dslContext)
    private val alg: (Record) -> (Long) = { res ->
        res.get(ARCHITECTURAL_SUPERVISION_SCHEDULE.ID)
    }

    fun create(dto: ArchitecturalSupervision, userSystemId: Long, oooId: Long) {
        val locationID = addressService.getOrCreatAddress(dto.addressDTO)

        val id = ARCHITECTURAL_SUPERVISION_SCHEDULE.set(dslContext, alg,
            Pair(ARCHITECTURAL_SUPERVISION_SCHEDULE.EMPLOYEE_ID, userSystemId),
            Pair(ARCHITECTURAL_SUPERVISION_SCHEDULE.ESPECIALLY_DANGEROUS_OPERATIONS_ID, oooId),
            Pair(ARCHITECTURAL_SUPERVISION_SCHEDULE.DATECHECK, dto.dateCheck),
            Pair(ARCHITECTURAL_SUPERVISION_SCHEDULE.LOCATION_ID, locationID.locationID)
        )
        createNotes(dto, id)
    }

    fun change(dto: ArchitecturalSupervision, assId: Long) {
        val architecturalSupervisionScheduleRecord =
            find(ARCHITECTURAL_SUPERVISION_SCHEDULE.ID.eq(assId)).into(ARCHITECTURAL_SUPERVISION_SCHEDULE)
        if (!oooService.urgently(architecturalSupervisionScheduleRecord.especiallyDangerousOperationsId)) {
            throw NotApprovedOOO("Данный ООО не утвержден")
        }
        dslContext.update(ARCHITECTURAL_SUPERVISION_SCHEDULE)
            .set(ARCHITECTURAL_SUPERVISION_SCHEDULE.ESPECIALLY_DANGEROUS_OPERATIONS_ID,
                architecturalSupervisionScheduleRecord.id)
            .set(ARCHITECTURAL_SUPERVISION_SCHEDULE.DATECHECK, dto.dateCheck)
            .where(ARCHITECTURAL_SUPERVISION_SCHEDULE.ID.eq(assId))
            .execute()
        changeNotes(dto, architecturalSupervisionScheduleRecord.id)
    }

    fun signatureEmployee(assId: Long, userSystemId: Long){
        dslContext.update(ARCHITECTURAL_SUPERVISION_SCHEDULE)
            .set(ARCHITECTURAL_SUPERVISION_SCHEDULE.EMPLOYER_SIGNATURE,true)
            .execute()
    }

    fun signature(assId: Long, userSystemId: Long) {
        ARCHITECTURAL_SUPERVISION_SCHEDULE_SIGNATURE.set(dslContext, alg,
            Pair(ARCHITECTURAL_SUPERVISION_SCHEDULE_SIGNATURE.EMPLOYEE_ID, userSystemId),
            Pair(ARCHITECTURAL_SUPERVISION_SCHEDULE_SIGNATURE.ARCHITECTURAL_SUPERVISION_SCHEDULE_ID, assId)
        )
    }

    fun checkEngineer(assId: Long, status: StatusCheck, userSystemId: Long) {
        dslContext.update(ARCHITECTURAL_SUPERVISION_SCHEDULE)
            .set(ARCHITECTURAL_SUPERVISION_SCHEDULE.CHIEF_ENGINEER, userSystemId)
            .set(ARCHITECTURAL_SUPERVISION_SCHEDULE.DATECHECK, status.date)
            .where(ARCHITECTURAL_SUPERVISION_SCHEDULE.ID.eq(assId))
            .execute()
    }

    private fun changeNotes(dto: ArchitecturalSupervision, assId: Long) {
        dslContext.delete(NOTES).where(NOTES.ARCHITECTURAL_SUPERVISION_SCHEDULE_ID.eq(assId)).execute()
        createNotes(dto, assId)
    }

    private fun createNotes(dto: ArchitecturalSupervision, assId: Long) {
        val list = dto.notes.map { note ->
            dslContext.insertInto(NOTES)
                .set(NOTES.NAME, note.name)
                .set(NOTES.TEXT, note.text)
                .set(NOTES.ARCHITECTURAL_SUPERVISION_SCHEDULE_ID, assId)
        }
        dslContext.batch(list).execute()
    }

}