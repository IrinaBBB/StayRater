package ru.aurorahost.repositories

import ru.aurorahost.models.ApiResponse
import ru.aurorahost.models.Hotel

class HotelRepositoryImpl: HotelRepository {
    override val hotels: Map<Int, List<Hotel>>
        get() = TODO("Not yet implemented")
    override val page1: List<Hotel>
        get() = TODO("Not yet implemented")
    override val page2: List<Hotel>
        get() = TODO("Not yet implemented")
    override val page3: List<Hotel>
        get() = TODO("Not yet implemented")
    override val page4: List<Hotel>
        get() = TODO("Not yet implemented")
    override val page5: List<Hotel>
        get() = TODO("Not yet implemented")

    override suspend fun getAllHotels(page: Int): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchHotels(name: String): ApiResponse {
        TODO("Not yet implemented")
    }
}