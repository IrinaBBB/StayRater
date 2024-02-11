package ru.aurorahost.stayraterapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.aurorahost.stayraterapp.domain.model.ApiResponse

interface StayRaterApi {

    @GET("/hotels")
    suspend fun getAllHotels(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/search")
    suspend fun searchHotels(
        @Query("name") name: String
    ): ApiResponse

}