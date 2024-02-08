package ru.aurorahost.stayraterapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.aurorahost.stayraterapp.data.local.dao.HotelDao
import ru.aurorahost.stayraterapp.model.Hotel
import ru.aurorahost.stayraterapp.model.HotelRemoteKey


@Database(entities = [Hotel::class, HotelRemoteKey::class], version = 1)
abstract class StayRaterDb : RoomDatabase() {

    abstract fun hotelDao(): HotelDao

}