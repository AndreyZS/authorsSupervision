package ru.alexandra_incr.authorssupervision.dto

import java.time.LocalDate

data class Test(val id:Long, val login:String,val historyPasswords: List<HistoryPassword>?)
data class HistoryPassword(val oldPassword: String, val date:LocalDate)