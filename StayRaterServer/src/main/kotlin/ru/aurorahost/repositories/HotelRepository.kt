package ru.aurorahost.repositories

import ru.aurorahost.models.ApiResponse
import ru.aurorahost.models.Hotel

interface HotelRepository {

    val hotels: Map<Int, List<Hotel>>

    val page1: List<Hotel>
    val page2: List<Hotel>
    val page3: List<Hotel>
    val page4: List<Hotel>
    val page5: List<Hotel>

    suspend fun getAllHotels(page: Int = 1): ApiResponse
    suspend fun searchHotels(name: String): ApiResponse
}