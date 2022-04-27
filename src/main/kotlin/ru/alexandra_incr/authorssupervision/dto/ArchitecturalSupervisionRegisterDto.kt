package ru.alexandra_incr.authorssupervision.dto

import java.time.LocalDateTime

class ArchitecturalSupervisionRegisterDto(
    val accordingScheduleDate:LocalDateTime,
    val accordingShift:Int,
    val actualVerificationDate: LocalDateTime,
    val actualVerificationShift: Int,
    val identifiedInconsistencies: String,
    val reasonsNoncompliance:String
)