package ru.aurorahost.stayraterapp.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash_screen")
    data object Welcome : Screen("welcome_screen")
    data object Home : Screen("home_screen")
    data object Details : Screen("details_screen/{hotelId}") {
        fun passHotelId(hotelId: Int): String {
            return "details_screen/$hotelId"
        }
    }
    data object Search : Screen("search_screen")
}
