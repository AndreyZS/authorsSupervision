package ru.alexandra_incr.authorssupervision.controller

import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.alexandra_incr.authorssupervision.dto.AddressDTO
import ru.alexandra_incr.authorssupervision.service.AddressService

@RestController
@RequestMapping("address")
@SecurityRequirement(name = "jwt")
class AddressController(
    private val addressService: AddressService
) {

    @PostMapping
    fun test(@RequestBody addressDTO: AddressDTO): AddressDTO {
       return addressService.getOrCreatAddress(addressDTO)
    }
}