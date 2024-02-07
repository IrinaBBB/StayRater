package ru.aurorahost.plugins

import io.ktor.application.Application
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.routing
import ru.aurorahost.routes.getAllHotels
import ru.aurorahost.routes.root
import ru.aurorahost.routes.searchHotels


fun Application.configureRouting() {
    routing {
        root()
        getAllHotels()
        searchHotels()

        static("/images") {
            resources("images")
        }
    }
}


