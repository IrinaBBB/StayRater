package ru.aurorahost.stayraterapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.aurorahost.stayraterapp.domain.model.ApiResponse

interface BorutoApi {

    @GET("/hotels")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse

}