package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.AccessRights.ACCESS_RIGHTS
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.config.Roles
import java.sql.SQLException

@Service
class RolesService(
    private val dslContext: DSLContext,
) {

    fun findOrCreate(name: String): Long {
        val rolesName = Roles.getRoles(name)
        return find(rolesName) ?: create(rolesName) ?: throw SQLException("нет роли")
    }

    private fun create(name: String) = dslContext
        .insertInto(ACCESS_RIGHTS)
        .set(ACCESS_RIGHTS.NAME, name)
        .returning().fetchOne()?.get(ACCESS_RIGHTS.ID)

    private fun find(name: String) = dslContext
        .select(ACCESS_RIGHTS.ID)
        .from(ACCESS_RIGHTS)
        .where(ACCESS_RIGHTS.NAME.eq(name))
        .fetchOne()?.get(ACCESS_RIGHTS.ID)
}