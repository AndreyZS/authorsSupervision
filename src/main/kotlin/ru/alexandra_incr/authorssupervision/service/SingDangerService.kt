package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.SignDanger
import org.jooq.generated.tables.SignDanger.*
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.service.crud.get
import ru.alexandra_incr.authorssupervision.service.crud.set

@Service
class SingDangerService(
    private val dslContext: DSLContext,
) {

    fun findOrCreate(singDanger: String): Long {
        val alg: (org.jooq.Record) -> (Long) = { res ->
            res.get(SIGN_DANGER.ID)
        }
        return SIGN_DANGER.get(dslContext, SIGN_DANGER.NAME.eq(singDanger), alg) ?: SIGN_DANGER.set(dslContext,
            alg,
            Pair(SIGN_DANGER.NAME, singDanger))
    }

}