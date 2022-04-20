package ru.alexandra_incr.authorssupervision.service.crud

import org.jooq.Condition
import org.jooq.DSLContext
import org.jooq.Table
import org.jooq.TableField

fun <R,E:org.jooq.Record> Table<E>.set(
    dslContext:DSLContext,
    alg: (org.jooq.Record) -> (R),
    vararg fields: Pair<TableField<E,*>, *>,
): R {
    return alg(dslContext.insertInto(this).set(fields.toMap()).returning().fetchOne()!!)
}

fun <R> Table<*>.get(dslContext:DSLContext, where: Condition, alg: (org.jooq.Record) -> (R)): R? {
    return dslContext.select().from(this)
        .where(where)
        .fetchOne()?.let { res ->
            alg(res)
        }
}