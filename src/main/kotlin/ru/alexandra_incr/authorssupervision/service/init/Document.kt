package ru.alexandra_incr.authorssupervision.service.init

import ru.alexandra_incr.authorssupervision.controller.StatusCheck
import ru.alexandra_incr.authorssupervision.dto.OOODto

interface Document<T> {
    /**
     * Создать документ
     * */
    fun create(dto: T, idPrevious:Long, userSystemId:Long )

    /**
     * Проверка инженером
     * */
    fun checkEngineer(documentId:Long, status: StatusCheck, userSystemId: Long)

    /**
     * Возвращает true, если документ проверен
     * */
    fun urgently(oorId: Long): Boolean
}