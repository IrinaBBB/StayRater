package ru.aurorahost.stayraterapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.aurorahost.stayraterapp.util.Constants.HOTEL_REMOTE_KEYS_DATABASE_TABLE

@Entity(tableName = HOTEL_REMOTE_KEYS_DATABASE_TABLE)
data class HotelRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)