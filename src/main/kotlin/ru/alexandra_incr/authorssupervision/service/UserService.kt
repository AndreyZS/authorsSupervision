package ru.alexandra_incr.authorssupervision.service

import org.jooq.Condition
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.generated.tables.AccessRights
import org.jooq.generated.tables.AccessRightsUsers.ACCESS_RIGHTS_USERS
import org.jooq.generated.tables.Division.*
import org.jooq.generated.tables.HistoryPassword.HISTORY_PASSWORD
import org.jooq.generated.tables.UserSystem
import org.jooq.generated.tables.UserSystem.USER_SYSTEM
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.config.Roles
import ru.alexandra_incr.authorssupervision.dto.Anonymous
import ru.alexandra_incr.authorssupervision.dto.AuthorizedUser
import ru.alexandra_incr.authorssupervision.exceptions.PasswordException
import ru.alexandra_incr.authorssupervision.exceptions.RegistrationException
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@Service
@PropertySource("classpath:secret.properties")
class UserService(
    private val dslContext: DSLContext,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val rolesService: RolesService,
    @Value("\${size_password}")
    private val sizePassword: Int,
) {
    val findUser: (Condition) -> Record = USER_SYSTEM.findByOne(dslContext)
    var logger: Logger = LoggerFactory.getLogger(UserService::class.java)

    fun changePassword(id: Long, password: String, newPassword: String) {
        if (newPassword.length < sizePassword)
            throw PasswordException("пароль слишком короткий")
        if (password != newPassword) {
            val user = findUser(USER_SYSTEM.ID.eq(id))
            if (bCryptPasswordEncoder.matches(password, user[USER_SYSTEM.PASSWORD])) {
                dslContext.insertInto(HISTORY_PASSWORD)
                    .set(HISTORY_PASSWORD.PASSWORD, password)
                    .set(HISTORY_PASSWORD.USER_ID, user[USER_SYSTEM.ID])
                    .set(HISTORY_PASSWORD.DATE, LocalDate.now())
                    .execute()
                dslContext.update(USER_SYSTEM)
                    .set(USER_SYSTEM.PASSWORD, bCryptPasswordEncoder.encode(newPassword))
                    .set(USER_SYSTEM.DATE_CHANGE_PASSWORD, LocalDate.now())
                    .where(USER_SYSTEM.ID.eq(id)).execute()
            }
        }
    }

    fun getUserByLoginAndPassword(login: String, password: String): UserDetails = dslContext
        .select()
        .from(USER_SYSTEM)
        .where(USER_SYSTEM.LOGIN.eq(login))
        .fetchOne()
        ?.map { record ->
            val verification = bCryptPasswordEncoder.matches(password, record[USER_SYSTEM.PASSWORD])
            if (verification) {
                val roles = dslContext.select().from(AccessRights.ACCESS_RIGHTS)
                    .innerJoin(ACCESS_RIGHTS_USERS)
                    .on(ACCESS_RIGHTS_USERS.USES_SYSTEM.eq(record[USER_SYSTEM.ID]))
                    .fetch().map { roles -> SimpleGrantedAuthority(roles[AccessRights.ACCESS_RIGHTS.NAME]) }
                dslContext.update(USER_SYSTEM)
                    .set(USER_SYSTEM.ONLINE_DATE,LocalDate.now())
                    .where(USER_SYSTEM.ID.eq(record[USER_SYSTEM.ID]))
                    .execute()
                AuthorizedUser(record[USER_SYSTEM.ID],
                    record[USER_SYSTEM.LOGIN],
                    roles,
                    record[USER_SYSTEM.DATE_CHANGE_PASSWORD],
                    record[USER_SYSTEM.LOCKED]
                )
            } else
                Anonymous

        } ?: Anonymous

    fun registration(fio:String, login: String, password: String, roles: List<Roles>,nameDivision: String) {
        if (password.length < sizePassword)
            throw PasswordException("пароль слишком короткий")

        val id = try {
            dslContext.insertInto(USER_SYSTEM)
                .set(USER_SYSTEM.FIO,fio)
                .set(USER_SYSTEM.DIVISION_ID,findDivision(nameDivision))
                .set(USER_SYSTEM.LOGIN, login)
                .set(USER_SYSTEM.PASSWORD, bCryptPasswordEncoder.encode(password))
                .set(USER_SYSTEM.DATE_CHANGE_PASSWORD, LocalDate.now())
                .set(USER_SYSTEM.DATE_REGISTRATION, LocalDate.now())
                .set(USER_SYSTEM.ONLINE_DATE,LocalDate.now())
                .returning().fetchOne()?.get(USER_SYSTEM.ID)
        } catch (e: Exception) {
            logger.error(e.message)
            throw RegistrationException("логин занят")
        }
        val listInsert = roles.map {
            dslContext.insertInto(ACCESS_RIGHTS_USERS)
                .set(ACCESS_RIGHTS_USERS.USES_SYSTEM, id)
                .set(ACCESS_RIGHTS_USERS.ACCESS_RIGHTS_ID, rolesService.findOrCreate(it.name))
        }
        dslContext.batch(listInsert).execute()
        logger.info("Пользователь $login зарегистрировался")
    }
    fun findDivision(nameDivision: String): Long {
        return dslContext.select().from(DIVISION)
            .where(DIVISION.DIVISION_.eq(nameDivision)).fetchOne()?.get(DIVISION.ID)
            ?: dslContext.insertInto(DIVISION).set(DIVISION.DIVISION_, nameDivision)
                .returning().fetchOne()?.get(DIVISION.ID)!!

    }
    @Scheduled(cron = "0 0 0 */1 * ?")
    private fun blockOldUser() {
        val listID = dslContext.select().from(USER_SYSTEM)
            .fetch().map { value ->
                if (120 >= ChronoUnit.DAYS.between(value[USER_SYSTEM.ONLINE_DATE], LocalDate.now())) {
                    value[USER_SYSTEM.ID]
                } else
                    null
            }.filterNotNull()
        dslContext.update(USER_SYSTEM)
            .set(USER_SYSTEM.LOCKED, true)
            .where(USER_SYSTEM.ID.`in`(listID))
            .execute()
    }
}


fun UserSystem.findByOne(dslContext: DSLContext): (Condition) -> Record = { predict ->
    dslContext.select()
        .from(this)
        .where(predict)
        .fetch().singleOrNull() ?: throw Exception("Запрос вернул больше одного пользователя")
}
