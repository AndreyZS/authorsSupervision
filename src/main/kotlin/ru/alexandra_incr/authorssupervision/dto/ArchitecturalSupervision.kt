package ru.alexandra_incr.authorssupervision.dto

import java.time.LocalDateTime

data class Note(val name: String, val text: String?)

open class ArchitecturalSupervision(open val dateCheck: LocalDateTime, open val addressDTO: AddressDTO,open val notes: List<Note>)
