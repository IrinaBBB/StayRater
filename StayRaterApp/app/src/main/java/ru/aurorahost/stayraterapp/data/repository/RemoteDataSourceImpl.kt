package ru.aurorahost.stayraterapp.data.repository


import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.aurorahost.stayraterapp.data.local.StayRaterDb
import ru.aurorahost.stayraterapp.data.paging_source.HotelRemoteMediator
import ru.aurorahost.stayraterapp.data.remote.StayRaterApi
import ru.aurorahost.stayraterapp.domain.model.Hotel
import ru.aurorahost.stayraterapp.domain.repository.RemoteDataSource
import ru.aurorahost.stayraterapp.util.Constants.ITEMS_PER_PAGE

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val stayRaterApi: StayRaterApi,
    private val stayRaterDb: StayRaterDb
) : RemoteDataSource {

    private val hotelDao = stayRaterDb.hotelDao()

    override fun getAllHotels(): Flow<PagingData<Hotel>> {
        val pagingSourceFactory = { hotelDao.getAllHotels() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HotelRemoteMediator(
                stayRaterApi = stayRaterApi,
                stayRaterDb = stayRaterDb
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHotels(): Flow<PagingData<Hotel>> {
        TODO("Not yet implemented")
    }
}