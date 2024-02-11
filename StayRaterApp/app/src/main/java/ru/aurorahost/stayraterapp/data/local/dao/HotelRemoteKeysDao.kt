package ru.aurorahost.stayraterapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.aurorahost.stayraterapp.domain.model.HotelRemoteKeys

@Dao
interface HotelRemoteKeysDao {

    @Query("SELECT * FROM hotel_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(hotelId: Int): HotelRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(hotelRemoteKeys: List<HotelRemoteKeys>)

    @Query("DELETE FROM hotel_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}