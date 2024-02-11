package ru.aurorahost.stayraterapp.domain.use_cases.get_all_hotels

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.aurorahost.stayraterapp.data.repository.Repository
import ru.aurorahost.stayraterapp.domain.model.Hotel

class GetAllHotelsUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hotel>> {
        return repository.getAllHotels()
    }
}