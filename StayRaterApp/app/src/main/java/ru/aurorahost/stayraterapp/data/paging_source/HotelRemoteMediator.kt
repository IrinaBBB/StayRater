package ru.aurorahost.stayraterapp.data.paging_source
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import ru.aurorahost.stayraterapp.data.local.StayRaterDb
import ru.aurorahost.stayraterapp.data.remote.StayRaterApi
import ru.aurorahost.stayraterapp.domain.model.Hotel
import ru.aurorahost.stayraterapp.domain.model.HotelRemoteKeys
import java.lang.Exception
import javax.inject.Inject

@ExperimentalPagingApi
class HotelRemoteMediator @Inject constructor(
    private val stayRaterApi: StayRaterApi,
    private val stayRaterDb: StayRaterDb
) : RemoteMediator<Int, Hotel>() {

    private val hotelDao = stayRaterDb.hotelDao()
    private val hotelRemoteKeysDao = stayRaterDb.hotelRemoteKeysDao()

    override suspend fun initialize(): InitializeAction {
        val currentTime = System.currentTimeMillis()
        val lastUpdated = hotelRemoteKeysDao.getRemoteKeys(hotelId = 1)?.lastUpdated ?: 0L
        val cacheTimeout = 1440

        val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60
        return if (diffInMinutes.toInt() <= cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Hotel>): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            val response = stayRaterApi.getAllHotels(page = page)
            if (response.hotels.isNotEmpty()) {
                stayRaterDb.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        hotelDao.deleteAllHotels()
                        hotelRemoteKeysDao.deleteAllRemoteKeys()
                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.hotels.map { hotel ->
                        HotelRemoteKeys(
                            id = hotel.id,
                            prevPage = prevPage,
                            nextPage = nextPage,
                            lastUpdated = response.lastUpdated
                        )
                    }
                    hotelRemoteKeysDao.addAllRemoteKeys(hotelRemoteKeys = keys)
                    hotelDao.addHotels(hotels = response.hotels)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Hotel>
    ): HotelRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                hotelRemoteKeysDao.getRemoteKeys(hotelId = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, Hotel>
    ): HotelRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { hotel ->
                hotelRemoteKeysDao.getRemoteKeys(hotelId = hotel.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, Hotel>
    ): HotelRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { hotel ->
                hotelRemoteKeysDao.getRemoteKeys(hotelId = hotel.id)
            }
    }

}