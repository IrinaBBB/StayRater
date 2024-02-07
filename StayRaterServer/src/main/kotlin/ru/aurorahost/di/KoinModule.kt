package ru.aurorahost.di

import org.koin.dsl.module
import ru.aurorahost.repositories.HotelRepository
import ru.aurorahost.repositories.HotelRepositoryImpl

val koinModule = module {
    single<HotelRepository> {
        HotelRepositoryImpl()
    }
}