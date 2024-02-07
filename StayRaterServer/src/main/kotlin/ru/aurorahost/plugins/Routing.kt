package ru.aurorahost.plugins

import io.ktor.application.Application
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.routing
import ru.aurorahost.routes.getAllHotels
import ru.aurorahost.routes.root


fun Application.configureRouting() {
    routing {
        root()
        getAllHotels()

        static("/images") {
            resources("images")
        }
    }
}


