package ru.alexandra_incr.authorssupervision.service

import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.jooq.DSLContext
import org.jooq.generated.tables.ListEspeciallyDangerousWork.LIST_ESPECIALLY_DANGEROUS_WORK
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.controller.StatusCheck
import ru.alexandra_incr.authorssupervision.dto.OORDto
import ru.alexandra_incr.authorssupervision.dto.WorkPlan
import ru.alexandra_incr.authorssupervision.service.crud.set
import java.io.File
import java.time.LocalDateTime
import kotlin.concurrent.thread


@Service
class OORService(
    private val dslContext: DSLContext,
    private val workPlanService: WorkPlanService,
    private val singDangerService: SingDangerService,
    private val addressService: AddressService,
) {

    fun create(oor: OORDto, workPlan: WorkPlan, userSystemId: Long) {
        val workPlanID = workPlanService.create(workPlan)
        val alg: (org.jooq.Record) -> Long = { res -> res.get(LIST_ESPECIALLY_DANGEROUS_WORK.ID) }
        LIST_ESPECIALLY_DANGEROUS_WORK.set(dslContext, alg,
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.NAME, oor.name),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.DATE_START, oor.dateStart),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.DATE_STOP, oor.dateStop),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.LOCATION_ID, addressService.getOrCreatAddress(oor.address).locationID),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.EMPLOYEE_ID, userSystemId),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.SIGN_DANGER_ID, singDangerService.findOrCreate(oor.singDanger)),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.CHIEF_ENGINEER,null),
            Pair(LIST_ESPECIALLY_DANGEROUS_WORK.WORK_PLAN_ID, workPlanID)
        )
    }

    fun checkEngineer(oorId: Long, status: StatusCheck, userSystemId: Long) {
        dslContext.update(LIST_ESPECIALLY_DANGEROUS_WORK)
            .set(LIST_ESPECIALLY_DANGEROUS_WORK.CHIEF_ENGINEER, userSystemId)
            .set(LIST_ESPECIALLY_DANGEROUS_WORK.DATECHECK, status.date)
            .where(LIST_ESPECIALLY_DANGEROUS_WORK.ID.eq(oorId))
            .execute()
    }

    fun urgently(oorId: Long): Boolean {
        return dslContext.select().from(LIST_ESPECIALLY_DANGEROUS_WORK)
            .where(LIST_ESPECIALLY_DANGEROUS_WORK.ID.eq(oorId).and(LIST_ESPECIALLY_DANGEROUS_WORK.DATECHECK.isNotNull))
            .fetchOne()?.let { true } ?: false
    }

    fun createExcel(dateStart: LocalDateTime, engineerId: Long) {
        val workbook: Workbook = XSSFWorkbook()
        val sheet: Sheet = workbook.createSheet()
        val file = File("c://one.xlsx")
        dslContext.select().from(LIST_ESPECIALLY_DANGEROUS_WORK)
            .where(LIST_ESPECIALLY_DANGEROUS_WORK.CHIEF_ENGINEER.eq(engineerId))
            .and(LIST_ESPECIALLY_DANGEROUS_WORK.DATE_START.lessOrEqual(dateStart))
            .fetch().forEachIndexed { index, record ->
                val header = sheet.createRow(index + 11)
                header.createCell(0).apply {
                    this.setCellValue(index.toString())
                }
                header.createCell(1).apply {
                    this.setCellValue(record.get(LIST_ESPECIALLY_DANGEROUS_WORK.LOCATION_ID).toString())
                }
                header.createCell(2).apply {
                    this.setCellValue(record.get(LIST_ESPECIALLY_DANGEROUS_WORK.EMPLOYEE_ID).toString())
                }
            }
        workbook.write(file.outputStream())
    }

}