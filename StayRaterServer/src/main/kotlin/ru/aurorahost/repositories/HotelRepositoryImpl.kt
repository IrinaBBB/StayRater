package ru.aurorahost.repositories

import ru.aurorahost.models.ApiResponse
import ru.aurorahost.models.Hotel

class HotelRepositoryImpl : HotelRepository {
    override val hotels: Map<Int, List<Hotel>>
        get() = TODO("Not yet implemented")
    override val page1 = listOf(
        Hotel(
            1,
            "Luxury Palace",
            "City Center",
            "A luxurious hotel with stunning views",
            4.8,
            200,
            "3:00 PM",
            "12:00 PM",
            listOf("Pool", "Spa", "Gym"),
            listOf("Deluxe Suite", "Executive Room"),
            listOf("Room Service", "Concierge")
        ),
        Hotel(
            2,
            "Seaside Retreat",
            "Beachfront",
            "A relaxing hotel by the sea",
            4.5,
            150,
            "4:00 PM",
            "11:00 AM",
            listOf("Beach Access", "Swimming Pool", "Restaurant"),
            listOf("Ocean View Room", "Standard Room"),
            listOf("Free Wi-Fi", "Parking")
        ),
        Hotel(
            3,
            "Mountain Lodge",
            "Mountain Range",
            "A cozy lodge nestled in the mountains",
            4.2,
            100,
            "2:00 PM",
            "10:00 AM",
            listOf("Hiking Trails", "Fireplace Lounge", "Bar"),
            listOf("Mountain View Cabin", "Standard Cabin"),
            listOf("Pet-Friendly", "Wi-Fi")
        ),
    )

    override val page2 = listOf(
        Hotel(
            4,
            "Urban Oasis",
            "Downtown",
            "A modern hotel in the heart of the city",
            4.7,
            180,
            "3:30 PM",
            "12:30 PM",
            listOf("Rooftop Bar", "Conference Rooms", "Fitness Center"),
            listOf("City View Suite", "Business Room"),
            listOf("Free Breakfast", "Airport Shuttle")
        ),
        Hotel(
            5,
            "Historic Inn",
            "Old Town",
            "A charming inn with a touch of history",
            4.4,
            120,
            "3:00 PM",
            "11:00 AM",
            listOf("Antique Furnishings", "Courtyard Garden", "Tea Room"),
            listOf("Vintage Suite", "Classic Room"),
            listOf("Complimentary Tea", "Guided Tours")
        ),
        Hotel(
            6,
            "Tropical Paradise",
            "Island Resort",
            "An exotic resort with tropical vibes",
            4.9,
            250,
            "4:00 PM",
            "12:00 PM",
            listOf("Private Beach", "Swim-up Bar", "Spa"),
            listOf("Luxury Villa", "Beachfront Bungalow"),
            listOf("All-Inclusive Dining", "Water Sports")
        ),
    )

    override val page3 = listOf(
        Hotel(
            7,
            "Riverside Manor",
            "Riverfront",
            "A peaceful retreat by the river",
            4.6,
            160,
            "3:30 PM",
            "11:30 AM",
            listOf("River View Terrace", "Fishing Dock", "Event Spaces"),
            listOf("Suite with River View", "Standard Room"),
            listOf("Free Parking", "Boat Rentals")
        ),
        Hotel(
            8,
            "Eco-friendly Haven",
            "Nature Reserve",
            "An eco-conscious hotel surrounded by nature",
            4.3,
            130,
            "2:00 PM",
            "10:30 AM",
            listOf("Solar Panels", "Nature Trails", "Organic Restaurant"),
            listOf("Green Suite", "Nature Cabin"),
            listOf("Recycling Program", "Electric Vehicle Charging")
        ),
        Hotel(
            9,
            "Skyline Tower Hotel",
            "Financial District",
            "A high-rise hotel with panoramic city views",
            4.7,
            200,
            "4:00 PM",
            "12:30 PM",
            listOf("Sky Lounge", "Business Center", "Indoor Pool"),
            listOf("Executive Suite", "Skyline View Room"),
            listOf("Free Wi-Fi", "Valet Parking")
        ),
    )

    override val page4 = listOf(
        Hotel(
            10,
            "Zen Retreat",
            "Mountain Retreat",
            "A serene retreat for relaxation and meditation",
            4.5,
            150,
            "3:30 PM",
            "11:00 AM",
            listOf("Meditation Gardens", "Yoga Studio", "Tea Pavilion"),
            listOf("Zen Suite", "Tranquil Room"),
            listOf("Daily Yoga Classes", "Vegetarian Dining")
        ),
        Hotel(
            11,
            "Sports Haven Hotel",
            "Sports District",
            "A sports-themed hotel for enthusiasts",
            4.4,
            180,
            "3:00 PM",
            "12:00 PM",
            listOf("Sports Bar", "Fitness Center", "Outdoor Courts"),
            listOf("Sports Suite", "Standard Room"),
            listOf("Game Nights", "Sports Equipment Rental")
        ),
        Hotel(
            12,
            "Countryside Lodge",
            "Rural Retreat",
            "A rustic lodge surrounded by countryside",
            4.2,
            100,
            "2:00 PM",
            "10:00 AM",
            listOf("Open Fields", "Bonfire Pit", "Farm-to-Table Restaurant"),
            listOf("Country Cabin", "Rural Room"),
            listOf("Petting Zoo", "Nature Workshops")
        )
    )

    override val page5 = listOf(
        Hotel(
            13,
            "Tranquility Bay Resort",
            "Coastal Area",
            "A serene resort overlooking the bay",
            4.6,
            180,
            "4:30 PM",
            "11:30 AM",
            listOf("Private Beach Access", "Spa Retreat", "Poolside Bar"),
            listOf("Oceanfront Suite", "Deluxe Room"),
            listOf("Gourmet Dining", "Beach Yoga Sessions")
        ),
        Hotel(
            14,
            "Golden Peaks Hotel",
            "Mountain Range",
            "A luxurious hotel with breathtaking mountain views",
            4.8,
            220,
            "3:30 PM",
            "12:00 PM",
            listOf("Mountain View Terrace", "Heated Pool", "Fine Dining"),
            listOf("Presidential Suite", "Panoramic Room"),
            listOf("24/7 Room Service", "Helicopter Tours")
        ),
        Hotel(
            15,
            "Cityscape Grand",
            "City Center",
            "A grand hotel in the heart of the bustling city",
            4.7,
            190,
            "4:00 PM",
            "12:00 PM",
            listOf("Skyline View Restaurant", "Spacious Ballroom", "Executive Lounge"),
            listOf("City View Suite", "Business Room"),
            listOf("Complimentary Breakfast", "Limousine Service")
        )
    )

    override suspend fun getAllHotels(page: Int): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchHotels(name: String): ApiResponse {
        TODO("Not yet implemented")
    }
}