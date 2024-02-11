package ru.aurorahost.stayraterapp.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.aurorahost.stayraterapp.domain.model.Hotel
import ru.aurorahost.stayraterapp.domain.repository.DataStoreOperations
import ru.aurorahost.stayraterapp.domain.repository.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHotels(): Flow<PagingData<Hotel>> {
        return remote.getAllHotels()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}