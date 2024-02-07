package ru.aurorahost.repositories

import ru.aurorahost.models.ApiResponse
import ru.aurorahost.models.Hotel

const val NEXT_PAGE_KEY = "nextPage"
const val PREVIOUS_PAGE_KEY = "prevPage"

class HotelRepositoryImpl : HotelRepository {

    override val hotels: Map<Int, List<Hotel>> by lazy {
        mapOf(
            1 to page1,
            2 to page2,
            3 to page3,
            4 to page4,
            5 to page5
        )
    }


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
            listOf("Room Service", "Concierge"),
            "/images/luxury_palace.jpg"
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
            listOf("Free Wi-Fi", "Parking"),
            "/images/seaside_retreat.jpg"
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
            listOf("Pet-Friendly", "Wi-Fi"),
            "/images/mountain_lodge.jpg"
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
            listOf("Free Breakfast", "Airport Shuttle"),
            "/images/urban_oasis.jpg"
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
            listOf("Complimentary Tea", "Guided Tours"),
            "/images/historic_inn.jpg"
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
            listOf("All-Inclusive Dining", "Water Sports"),
            "/images/tropical_paradise.jpg"
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
            listOf("Free Parking", "Boat Rentals"),
            "/images/riverside_manor.jpg"
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
            listOf("Recycling Program", "Electric Vehicle Charging"),
            "/images/eco_friendly_haven.jpg"
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
            listOf("Free Wi-Fi", "Valet Parking"),
            "/images/skyline_tower_hotel.jpg"
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
            listOf("Daily Yoga Classes", "Vegetarian Dining"),
            "/images/zen_retreat.jpg"
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
            listOf("Game Nights", "Sports Equipment Rental"),
            "/images/sports_haven.jpg"
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
            listOf("Petting Zoo", "Nature Workshops"),
            "/images/countryside_lodge.jpg"
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
            listOf("Gourmet Dining", "Beach Yoga Sessions"),
            "/images/gourmet_dining.jpg"
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
            listOf("24/7 Room Service", "Helicopter Tours"),
            "/images/golden_peaks_hotel.jpg"
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
            listOf("Complimentary Breakfast", "Limousine Service"),
            "/images/cityscape_grand.jpg"
        )
    )

    override suspend fun getAllHotels(page: Int): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            prevPage = calculatePage(page = page)[PREVIOUS_PAGE_KEY],
            nextPage = calculatePage(page = page)[NEXT_PAGE_KEY],
            hotels = hotels[page]!!,
            lastUpdated = System.currentTimeMillis()
        )
    }


    private fun calculatePage(page: Int): Map<String, Int?> {
        var prevPage: Int? = page
        var nextPage: Int? = page
        if (page in 1..4) {
            nextPage = nextPage?.plus(1)
        }
        if (page in 2..5) {
            prevPage = prevPage?.minus(1)
        }
        if (page == 1) {
            prevPage = null
        }
        if (page == 5) {
            nextPage = null
        }
        return mapOf(PREVIOUS_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)
    }

    override suspend fun searchHotels(name: String): ApiResponse {
        TODO("Not yet implemented")
    }
}