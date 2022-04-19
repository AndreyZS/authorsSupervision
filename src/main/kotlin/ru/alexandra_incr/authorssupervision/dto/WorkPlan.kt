package ru.alexandra_incr.authorssupervision.dto

import java.time.LocalDateTime

open class WorkPlan(
    open val name: String,
    open val aboutUpdate: String? = null,
    open val dateUpdate: LocalDateTime? = null,
)

data class RequestWorkPlan(
    val id: Long, override val name: String, override val aboutUpdate: String?,
    override val dateUpdate: LocalDateTime?,
) : WorkPlan(name, aboutUpdate, dateUpdate)
