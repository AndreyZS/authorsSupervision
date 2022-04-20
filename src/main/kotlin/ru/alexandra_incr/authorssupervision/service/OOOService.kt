package ru.alexandra_incr.authorssupervision.service

import org.jooq.DSLContext
import org.jooq.generated.tables.EspeciallyDangerousOperations
import org.jooq.generated.tables.EspeciallyDangerousOperations.*
import org.jooq.generated.tables.ListEspeciallyDangerousWork
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.controller.StatusCheck
import ru.alexandra_incr.authorssupervision.dto.OOODto
import ru.alexandra_incr.authorssupervision.dto.RequestOORDto
import ru.alexandra_incr.authorssupervision.dto.UserSystem
import ru.alexandra_incr.authorssupervision.service.crud.set


@Service
class OOOService(
    private val dslContext: DSLContext,
    private val addressService: AddressService
) {


    fun create(OOODto: OOODto, oorId:Long, userSystemId:Long ){
        val alg:(org.jooq.Record)->(Long) = {res->
            res.get(ESPECIALLY_DANGEROUS_OPERATIONS.ID)
        }
        ESPECIALLY_DANGEROUS_OPERATIONS.set(dslContext,alg,
            Pair(ESPECIALLY_DANGEROUS_OPERATIONS.NAME,OOODto.name),
            Pair(ESPECIALLY_DANGEROUS_OPERATIONS.DATE_START,OOODto.dateStart),
            Pair(ESPECIALLY_DANGEROUS_OPERATIONS.DATE_STOP,OOODto.dateStop),
            Pair(ESPECIALLY_DANGEROUS_OPERATIONS.LOCATION_ID,addressService.getOrCreatAddress(OOODto.address).locationID),
            Pair(ESPECIALLY_DANGEROUS_OPERATIONS.EMPLOYEE_ID,userSystemId),
            Pair(ESPECIALLY_DANGEROUS_OPERATIONS.OOR_ID,oorId)
            )
    }

    fun update(oooId:Long, status: StatusCheck, userSystemId: Long){
        dslContext.update(ESPECIALLY_DANGEROUS_OPERATIONS)
            .set(ESPECIALLY_DANGEROUS_OPERATIONS.CHIEF_ENGINEER,userSystemId)
            .set(ESPECIALLY_DANGEROUS_OPERATIONS.DATECHECK,status.date)
            .where(ESPECIALLY_DANGEROUS_OPERATIONS.ID.eq(oooId))
            .execute()
    }
}