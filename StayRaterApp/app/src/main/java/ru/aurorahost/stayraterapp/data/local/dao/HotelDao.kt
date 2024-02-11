package ru.aurorahost.stayraterapp.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.aurorahost.stayraterapp.domain.model.Hotel

@Dao
interface HotelDao {

    @Query("SELECT * FROM hotel_table ORDER BY id ASC")
    fun getAllHotels(): PagingSource<Int, Hotel>

    @Query("SELECT * FROM hotel_table WHERE id=:hotelId")
    fun getSelectedHotel(hotelId: Int): Hotel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHotels(hotels: List<Hotel>)

    @Query("DELETE FROM hotel_table")
    suspend fun deleteAllHotels()

}