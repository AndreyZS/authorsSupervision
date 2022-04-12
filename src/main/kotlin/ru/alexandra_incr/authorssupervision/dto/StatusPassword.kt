package ru.alexandra_incr.authorssupervision.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import java.time.temporal.ChronoUnit
@Schema(
    oneOf = [NewPassword::class,
        MiddlePassword::class,
        OldPassword::class
    ]
)
sealed interface StatusPassword {
    val type:String
    companion object{
       operator fun invoke(date: LocalDate?): StatusPassword {
            val now = LocalDate.now()
            val x = ChronoUnit.DAYS.between(date, now)
            return if (x < 10)
                NewPassword
            else if (x in 11..39)
                MiddlePassword
            else
                OldPassword
        }
    }

}
@Schema(
    enumAsRef = true
)
object NewPassword : StatusPassword {
    override val type: String
        get() = "NewPassword"
}

@Schema(
    enumAsRef = true
)
object MiddlePassword : StatusPassword {
    override val type: String
        get() = "MiddlePassword"
}

@Schema(
    enumAsRef = true
)
object OldPassword : StatusPassword {
    override val type: String
        get() = "OldPassword"
}

data class JwtAndStatus(val jwt: String, val status: StatusPassword)