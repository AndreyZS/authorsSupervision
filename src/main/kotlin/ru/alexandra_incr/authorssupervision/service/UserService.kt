package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.AccessRights
import org.jooq.generated.tables.AccessRightsUsers
import org.jooq.generated.tables.AccessRightsUsers.*
import org.jooq.generated.tables.UserSystem.USER_SYSTEM
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.dto.Anonymous
import ru.alexandra_incr.authorssupervision.dto.AuthorizedUser
import ru.alexandra_incr.authorssupervision.exceptions.RegistrationException

@Service
class UserService(
    private val dslContext: DSLContext,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val rolesService: RolesService,
) {

    var logger: Logger = LoggerFactory.getLogger(UserService::class.java)

    fun getUserByLoginAndPassword(login: String, password: String): UserDetails = dslContext
        .select()
        .from(USER_SYSTEM)
        .where(USER_SYSTEM.LOGIN.eq(login))
        .fetchOne()
        ?.map { rec ->
            val verification = bCryptPasswordEncoder.matches(password, rec[USER_SYSTEM.PASSWORD])
            if (verification) {
                val roles = dslContext.select().from(AccessRights.ACCESS_RIGHTS)
                    .innerJoin(ACCESS_RIGHTS_USERS)
                    .on(ACCESS_RIGHTS_USERS.USES_SYSTEM.eq(rec[USER_SYSTEM.ID]))
                    .fetch().map { roles -> SimpleGrantedAuthority(roles[AccessRights.ACCESS_RIGHTS.NAME]) }
                AuthorizedUser(rec[USER_SYSTEM.ID], rec[USER_SYSTEM.LOGIN], roles)
            } else
                Anonymous

        } ?: Anonymous

    fun registration(login: String, password: String, roles: List<String>) {
        val id = try {
            dslContext.insertInto(USER_SYSTEM)
                .set(USER_SYSTEM.LOGIN, login)
                .set(USER_SYSTEM.PASSWORD, bCryptPasswordEncoder.encode(password))
                .returning().fetchOne()?.get(USER_SYSTEM.ID)
        } catch (e: Exception) {
            logger.error(e.message)
            throw RegistrationException("логин занят")
        }
        val listInsert = roles.map { dslContext.insertInto(ACCESS_RIGHTS_USERS)
            .set(ACCESS_RIGHTS_USERS.USES_SYSTEM,id)
            .set(ACCESS_RIGHTS_USERS.ACCESS_RIGHTS_ID,rolesService.findOrCreate(it))
        }
        dslContext.batch(listInsert).execute()
        logger.info("Пользователь $login зарегистрировался")
    }
}
