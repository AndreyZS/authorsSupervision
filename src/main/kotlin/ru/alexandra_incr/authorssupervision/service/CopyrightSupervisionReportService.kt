package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.ArchitecturalSupervisionSchedule
import org.jooq.generated.tables.ArchitecturalSupervisionScheduleSignature
import org.jooq.generated.tables.CopyrightSupervisionReport
import org.jooq.generated.tables.CopyrightSupervisionReport.*
import org.jooq.generated.tables.CopyrightSupervisionReportSignature
import org.jooq.generated.tables.CopyrightSupervisionReportSignature.*
import org.jooq.generated.tables.ListEspeciallyDangerousWork
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.controller.StatusCheck
import ru.alexandra_incr.authorssupervision.dto.CopyrightSupervisionReportDto
import ru.alexandra_incr.authorssupervision.service.crud.set


@Service
class CopyrightSupervisionReportService(
    private val dslContext: DSLContext,
    private val addressService: AddressService,
    private val architecturalSupervisionScheduleService: ArchitecturalSupervisionScheduleService
) {

    private val alg: (org.jooq.Record) -> (Long) = { res ->
        res.get(COPYRIGHT_SUPERVISION_REPORT.ID)
    }

    fun create(
        dto: CopyrightSupervisionReportDto,
        employeeId: Long,
        presenceId: Long?,
        leaderId: Long,
        workPlan: Long,
    ) {
        COPYRIGHT_SUPERVISION_REPORT.set(
            dslContext, alg,
            Pair(COPYRIGHT_SUPERVISION_REPORT.EMPLOYEE_ID, employeeId),
            Pair(COPYRIGHT_SUPERVISION_REPORT.DATE_CREATE, dto.dateStart),
            Pair(COPYRIGHT_SUPERVISION_REPORT.PRESENCE, presenceId),
            Pair(COPYRIGHT_SUPERVISION_REPORT.DATE_PRESENCE, dto.datePresence),
            Pair(COPYRIGHT_SUPERVISION_REPORT.LOCATION_ID, addressService.getOrCreatAddress(dto.addressDTO).locationID),
            Pair(COPYRIGHT_SUPERVISION_REPORT.RESPONSIBLE_LEADER, leaderId),
            Pair(COPYRIGHT_SUPERVISION_REPORT.WORK_DURING_CHECK, dto.workDuringCheck),
            Pair(COPYRIGHT_SUPERVISION_REPORT.AUDITED_UNIT, dto.auditedUnit),
            Pair(COPYRIGHT_SUPERVISION_REPORT.CHANGES_MADE, dto.changeMade),
            Pair(COPYRIGHT_SUPERVISION_REPORT.EMPLOYEES_REQUIREMENTS_TECHNOLOGICAL_DOCUMENTATION,
                dto.employeesRequirementsTechnologicalDocumentation),
            Pair(COPYRIGHT_SUPERVISION_REPORT.EMPLOYEES_REQUIREMENTS_TECHNOLOGICAL_DOCUMENTATION_COMMENT,
                dto.employeesRequirementsTechnologicalDocumentationComment),
            Pair(COPYRIGHT_SUPERVISION_REPORT.EXECUTION_PREPARATORY_WORK_ACCORDANCE_PPR,
                dto.executionPreparatoryWorkAccordancePPR),
            Pair(COPYRIGHT_SUPERVISION_REPORT.EXECUTION_PREPARATORY_WORK_ACCORDANCE_PPR_COMMENT,
                dto.executionPreparatoryWorkAccordancePPRComment),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_ORGANIZATION_DESIGN_SOLUTION_SPECIFIED_PPR,
                dto.complianceOrganizationDesignSolutionSpecifiedPPR),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_ORGANIZATION_DESIGN_SOLUTION_SPECIFIED_PPR_COMMENT,
                dto.complianceOrganizationDesignSolutionSpecifiedPPRComment),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_WORK_PERFORMED_DESIGN_SOLUTION,
                dto.complianceWorkPerformedDesignSolution),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_WORK_PERFORMED_DESIGN_SOLUTION_COMMENT,
                dto.complianceWorkPerformedDesignSolutionComment),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_SEQUENCE_TECHNOLOGY_RELEVANT_OPERATIONS,
                dto.complianceSequenceTechnologyRelevantOperations),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_SEQUENCE_TECHNOLOGY_RELEVANT_OPERATIONS_COMMENT,
                dto.complianceSequenceTechnologyRelevantOperationsComment),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_APPLIED_MEANS_MECHANIZATION_SPECIFIED_PPR,
                dto.complianceAppliedMeansMechanizationSpecifiedPPR),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_APPLIED_MEANS_MECHANIZATION_SPECIFIED_PPR_COMMENT,
                dto.complianceAppliedMeansMechanizationSpecifiedPPRComment),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_USED_RIGGING_EQUIPMENT_REQUIREMENTS_PPR,
                dto.complianceUsedRiggingEquipmentRequirementsPPR),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_USED_RIGGING_EQUIPMENT_REQUIREMENTS_PPR_COMMENT,
                dto.complianceUsedRiggingEquipmentRequirementsPPRComment),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_TRUSS_GRIPPING_DEVICES_REQUIREMENTS_PPR,
                dto.complianceTrussRippingDevicesRequirementsPPR),
            Pair(COPYRIGHT_SUPERVISION_REPORT.COMPLIANCE_TRUSS_GRIPPING_DEVICES_REQUIREMENTS_PPR_COMMENT,
                dto.complianceTrussRippingDevicesRequirementsPPRComment)

        )
    }

    fun checkEngineer(oorId: Long, status: StatusCheck, userSystemId: Long) {
        dslContext.update(COPYRIGHT_SUPERVISION_REPORT)
            .set(COPYRIGHT_SUPERVISION_REPORT.CHIEF_ENGINEER, userSystemId)
            .set(COPYRIGHT_SUPERVISION_REPORT.DATECHECK, status.date)
            .where(COPYRIGHT_SUPERVISION_REPORT.ID.eq(oorId))
            .execute()
    }
    fun signatureEmployee(assId: Long, userSystemId: Long){
        dslContext.update(COPYRIGHT_SUPERVISION_REPORT)
            .set(COPYRIGHT_SUPERVISION_REPORT.SIGNATURE,true)
            .execute()
    }

    fun signature(assId: Long, userSystemId: Long) {
        COPYRIGHT_SUPERVISION_REPORT_SIGNATURE.set(dslContext, alg,
            Pair(COPYRIGHT_SUPERVISION_REPORT_SIGNATURE.EMPLOYEE_ID, userSystemId),
            Pair(COPYRIGHT_SUPERVISION_REPORT_SIGNATURE.COPYRIGHT_SUPERVISION_REPORT_ID, assId)
        )
    }
}