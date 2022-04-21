package ru.alexandra_incr.authorssupervision.dto

import java.time.LocalDateTime

class CopyrightSupervisionReportDto(
    val addressDTO: AddressDTO,
    val dateStart: LocalDateTime,
    val workDuringCheck: String? = null,
    val datePresence: LocalDateTime? = null,
    val changeMade:String? = null,
    val auditedUnit:String? = null,
    val employeesRequirementsTechnologicalDocumentation:Boolean,
    val employeesRequirementsTechnologicalDocumentationComment:String?=null,
    val executionPreparatoryWorkAccordancePPR:Boolean,
    val executionPreparatoryWorkAccordancePPRComment:String?=null,
    val complianceOrganizationDesignSolutionSpecifiedPPR:Boolean,
    val complianceOrganizationDesignSolutionSpecifiedPPRComment:String?=null,
    val complianceWorkPerformedDesignSolution:Boolean,
    val complianceWorkPerformedDesignSolutionComment:String?=null,
    val complianceSequenceTechnologyRelevantOperations:Boolean,
    val complianceSequenceTechnologyRelevantOperationsComment:String?=null,
    val complianceAppliedMeansMechanizationSpecifiedPPR:Boolean,
    val complianceAppliedMeansMechanizationSpecifiedPPRComment:String?=null,
    val complianceUsedRiggingEquipmentRequirementsPPR:Boolean,
    val complianceUsedRiggingEquipmentRequirementsPPRComment:String?=null,
    val complianceTrussRippingDevicesRequirementsPPR:Boolean,
    val complianceTrussRippingDevicesRequirementsPPRComment:String?=null
)
