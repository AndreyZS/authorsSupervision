package ru.alexandra_incr.authorssupervision.service


import org.jooq.Condition
import org.jooq.DSLContext
import org.jooq.Table
import org.jooq.generated.tables.Company.*
import org.jooq.generated.tables.Location.*
import org.jooq.generated.tables.Workshop.WORKSHOP
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.dto.AddressDTO
import java.util.function.Predicate
import ru.alexandra_incr.authorssupervision.service.crud.get
import ru.alexandra_incr.authorssupervision.service.crud.set

data class AddressID(val locationID:Long,val workshopId: Long,val companyId: Long)
@Service
class AddressService(
    private val dslContext: DSLContext,
) {
    fun getOrCreatAddress(addressDTO: AddressDTO): AddressID {
        val alg: (org.jooq.Record) -> (IdName) = { res ->
            Pair(
                res.get(LOCATION.ID),
                res.get(LOCATION.NAME)
            )
        }
        val res = getOrCreateWorkshop(addressDTO.workshop, addressDTO.company)
        val location =
            (LOCATION.get(dslContext, LOCATION.NAME.eq(addressDTO.location), alg)) ?: LOCATION.set(dslContext,
                alg,
                Pair(LOCATION.NAME, addressDTO.location),
                Pair(LOCATION.WORKSHOP_ID, res.workshopId))
        return AddressID(location.first, res.workshopId, res.companyId)
    }

    private fun getOrCreateWorkshop(name: String, companyName: String): WorkshopCompany {
        val alg: (org.jooq.Record) -> (IdName) = { res ->
            Pair(
                res.get(WORKSHOP.ID),
                res.get(WORKSHOP.NAME)
            )
        }
        val resCompany = getOrCreateCompany(companyName)
        val resWorkshop = (WORKSHOP.get(dslContext, WORKSHOP.NAME.eq(name), alg)) ?: WORKSHOP.set(dslContext, alg,
            Pair(WORKSHOP.NAME, name),
            Pair(WORKSHOP.COMPANY_ID, resCompany.first))
        return WorkshopCompany(resWorkshop.first, resWorkshop.second, resCompany.first, resCompany.second)
    }

    private fun getOrCreateCompany(name: String): IdName {
        val alg: (org.jooq.Record) -> (IdName) = { res ->
            Pair(
                res.get(COMPANY.ID),
                res.get(COMPANY.NAME)
            )
        }
        return COMPANY.get(dslContext, COMPANY.NAME.eq(name), alg) ?: COMPANY.set(dslContext, alg, Pair(COMPANY.NAME, name))
    }


    private data class WorkshopCompany(
        val workshopId: Long,
        val workshopName: String,
        val companyId: Long,
        val companyName: String,
    )
}

typealias IdName = Pair<Long, String>

