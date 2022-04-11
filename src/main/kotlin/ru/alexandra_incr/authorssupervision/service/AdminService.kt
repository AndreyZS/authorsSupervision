package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.HistoryPassword.HISTORY_PASSWORD
import org.jooq.generated.tables.UserSystem.USER_SYSTEM
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.dto.HistoryPassword
import ru.alexandra_incr.authorssupervision.dto.Test

@Service
class AdminService(
    private val dslContext: DSLContext,
) {


    fun getListHistoryPassword(): List<Test> {
        val map = mutableMapOf<Long, Test>()
        dslContext.select().from(USER_SYSTEM)
            .join(HISTORY_PASSWORD).on(USER_SYSTEM.ID.eq(HISTORY_PASSWORD.USER_ID))
            .fetch()
            .forEach {
                val user = it.into(USER_SYSTEM)
                if (map[user.id] == null) {
                    val password = HistoryPassword(it[HISTORY_PASSWORD.PASSWORD], it[HISTORY_PASSWORD.DATE])
                    map.put(user.id, Test(user.id, user.login, listOf(password)))
                } else {
                    val newUser = map[user.id]
                    if (newUser != null) {
                        val listPassword =
                            newUser.historyPasswords?.plus(HistoryPassword(it[HISTORY_PASSWORD.PASSWORD],
                                it[HISTORY_PASSWORD.DATE]))
                        map.put(user.id, newUser.copy(historyPasswords = listPassword))
                    }
                }
            }
        return map.map { it.value }
    }
}