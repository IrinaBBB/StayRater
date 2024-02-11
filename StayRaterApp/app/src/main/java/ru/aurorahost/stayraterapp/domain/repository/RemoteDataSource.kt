package ru.aurorahost.stayraterapp.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.aurorahost.stayraterapp.domain.model.Hotel

interface RemoteDataSource {
    fun getAllHotels(): Flow<PagingData<Hotel>>
    fun searchHotels(): Flow<PagingData<Hotel>>
}