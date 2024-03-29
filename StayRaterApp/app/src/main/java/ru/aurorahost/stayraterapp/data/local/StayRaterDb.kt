package ru.aurorahost.stayraterapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.aurorahost.stayraterapp.data.local.dao.HotelDao
import ru.aurorahost.stayraterapp.data.local.dao.HotelRemoteKeysDao
import ru.aurorahost.stayraterapp.domain.model.Hotel
import ru.aurorahost.stayraterapp.domain.model.HotelRemoteKeys


@Database(entities = [Hotel::class, HotelRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class StayRaterDb : RoomDatabase() {

    abstract fun hotelDao(): HotelDao
    abstract fun hotelRemoteKeysDao(): HotelRemoteKeysDao

}