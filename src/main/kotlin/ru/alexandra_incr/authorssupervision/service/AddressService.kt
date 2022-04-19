package ru.alexandra_incr.authorssupervision.service


import org.jooq.DSLContext
import org.jooq.Table
import org.jooq.generated.tables.Company.*
import org.jooq.generated.tables.Location.*
import org.jooq.generated.tables.Workshop.WORKSHOP
import org.jooq.impl.DSL
import org.springframework.stereotype.Service
import ru.alexandra_incr.authorssupervision.dto.AddressDTO

@Service
class AddressService(
    private val dslContext: DSLContext,
) {

    private fun getOrCreateLocation(addressDTO: AddressDTO): AddressDTO {
        val res = getOrCreateWorkshop(addressDTO.workshop, addressDTO.company)
        val location = (get(addressDTO.location, LOCATION) ?: set(LOCATION, Pair("name", addressDTO.location),
            Pair("workshop_id", res.workshopId)))
        return AddressDTO(location.second, res.workshopName, res.companyName)
    }

    private fun getOrCreateWorkshop(name: String, companyName: String): WorkshopCompany {
        val resCompany = getOrCreateCompany(companyName)
        val resWorkshop = (get(name, WORKSHOP) ?: set(WORKSHOP,
            Pair("name", name),
            Pair("company_id", resCompany.first)))
        return WorkshopCompany(resWorkshop.first, resWorkshop.second, resCompany.first, resCompany.second)
    }

    private fun getOrCreateCompany(name: String): IdName {
        return get(name, COMPANY) ?: set(COMPANY, Pair("name", name))
    }

    private fun set(table: Table<*>, vararg fields: Pair<String, *>): IdName {
        return dslContext.insertInto(table).set(fields.toMap()).returning().fetchOne()!!.let { res ->
            Pair(
                res.get(table.field("id", Long::class.java)),
                res.get(table.field("name", String()::class.java))
            )
        }
    }

    private fun get(name: String, table: Table<*>): IdName? {
        return dslContext.select().from(table)
            .where(table.field("name", String::class.java)?.eq(name)
                ?: DSL.condition(false))
            .fetchOne()?.let { res ->
                Pair(
                    res.get(table.field("id", Long::class.java)),
                    res.get(table.field("name", String()::class.java))
                )
            }

    }

    private data class WorkshopCompany(val workshopId: Long, val workshopName: String, val companyId: Long, val companyName: String)
}

typealias IdName = Pair<Long, String>

