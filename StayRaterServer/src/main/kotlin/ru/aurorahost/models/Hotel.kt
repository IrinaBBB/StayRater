package ru.aurorahost.models

import kotlinx.serialization.Serializable

@Serializable
data class Hotel(
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
