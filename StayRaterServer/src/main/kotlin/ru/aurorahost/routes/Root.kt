package ru.aurorahost.routes

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get


fun Route.root() {
    get("/") {
        call.respond(
            message = "Welcome to StayRater API!",
            status = HttpStatusCode.OK
        )
    }
}