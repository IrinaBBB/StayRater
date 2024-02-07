package ru.aurorahost.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import ru.aurorahost.models.ApiResponse
import ru.aurorahost.repositories.HotelRepository
import org.koin.ktor.ext.inject


fun Route.getAllHotels() {
    val hotelRepository: HotelRepository by inject()

    get("/hotels") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            println("NEW PAGE: $page")
            require(page in 1..5)

            val apiResponse = hotelRepository.getAllHotels(page = page)
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, message = "Only Numbers Allowed."),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, message = "Hotels not Found."),
                status = HttpStatusCode.NotFound
            )
        }
    }
}