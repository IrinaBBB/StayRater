package ru.aurorahost.stayraterapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.aurorahost.stayraterapp.domain.model.HotelRemoteKey

@Dao
interface HotelRemoteKeyDao {

    @Query("SELECT * FROM hotel_remote_key_table WHERE id = :id")
    suspend fun getRemoteKey(id: Int): HotelRemoteKey?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(hotelRemoteKeys: List<HotelRemoteKey>)

    @Query("DELETE FROM hotel_remote_key_table")
    suspend fun deleteAllRemoteKeys()

}