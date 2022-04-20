package ru.alexandra_incr.authorssupervision.dto

import java.time.LocalDateTime

open class OOODto(
    val name: String,
    val dateStart: LocalDateTime,
    val dateStop: LocalDateTime? = null,
    val singDanger: String,
    val address: AddressDTO,
)
