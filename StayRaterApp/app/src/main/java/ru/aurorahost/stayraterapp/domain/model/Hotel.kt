@file:Suppress("PLUGIN_IS_NOT_ENABLED")

package ru.aurorahost.stayraterapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import ru.aurorahost.stayraterapp.util.Constants.HOTEL_DATABASE_TABLE

@Serializable
@Entity(tableName = HOTEL_DATABASE_TABLE)
data class Hotel(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val location: String,
    val description: String,
    val rating: Double,
    val numberOfRooms: Int,
    val checkInTime: String,
    val checkOutTime: String,
    val amenities: List<String>,
    val roomTypes: List<String>,
    val services: List<String>,
    val image: String
)