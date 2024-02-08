package ru.aurorahost.stayraterapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.aurorahost.stayraterapp.util.Constants.HOTEL_REMOTE_KEY_DATABASE_TABLE

@Entity(tableName = HOTEL_REMOTE_KEY_DATABASE_TABLE)
data class HotelRemoteKey(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevKey: Int?,
    val nextKey: Int?
)