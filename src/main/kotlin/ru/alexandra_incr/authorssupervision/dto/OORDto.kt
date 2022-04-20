package ru.alexandra_incr.authorssupervision.dto

import java.time.LocalDateTime

open class OORDto(
    open val name: String,
    open val dateStart: LocalDateTime,
    open val dateStop: LocalDateTime? = null,
    open val singDanger: String,
    open val address: AddressDTO,
)

data class RequestOORDto(
    val id: Long, override val name: String,
    override val dateStart: LocalDateTime,
    override val dateStop: LocalDateTime? = null,
    override val singDanger: String,
    override val address: AddressDTO,
) : OORDto(name, dateStart, dateStop, singDanger, address)
