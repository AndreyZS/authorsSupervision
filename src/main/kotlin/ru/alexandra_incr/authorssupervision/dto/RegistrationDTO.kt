package ru.alexandra_incr.authorssupervision.dto

import org.jooq.generated.tables.Division
import ru.alexandra_incr.authorssupervision.config.Roles

data class RegistrationDTO(val fio:String,val login:String,val password:String,val roles:List<Roles>, val nameDivision: String)
