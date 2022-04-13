package ru.alexandra_incr.authorssupervision.dto

import org.jooq.generated.tables.Division

data class RegistrationDTO(val fio:String,val login:String,val password:String,val roles:List<String>, val nameDivision: String)
