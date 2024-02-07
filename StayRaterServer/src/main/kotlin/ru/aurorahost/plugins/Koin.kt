package ru.aurorahost.plugins

import io.ktor.application.*
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger
import ru.aurorahost.di.koinModule

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger()
        modules(koinModule)
    }
}