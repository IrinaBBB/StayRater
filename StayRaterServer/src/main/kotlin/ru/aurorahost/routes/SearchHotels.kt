package ru.aurorahost.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject
import ru.aurorahost.repositories.HotelRepository

fun Route.searchHotels() {
    val hotelRepository: HotelRepository by inject()

    get("/search") {
        val name = call.request.queryParameters["name"]!!

        val apiResponse = hotelRepository.searchHotels(query = name)

        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}