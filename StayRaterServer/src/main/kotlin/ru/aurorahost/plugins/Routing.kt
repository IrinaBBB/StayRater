package ru.aurorahost.plugins

import io.ktor.application.Application
import io.ktor.routing.routing
import ru.aurorahost.routes.root


fun Application.configureRouting() {
    routing {
        root()
    }
}


