package ru.aurorahost.stayraterapp.domain.model

import androidx.annotation.DrawableRes
import ru.aurorahost.stayraterapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        image = R.drawable.welcome,
        title = "Welcome to StayRater!",
        description = "Your ultimate guide to finding the perfect stay! Let's get started!"
    )

    object Second : OnBoardingPage(
        image = R.drawable.bedroom,
        title = "Discover Top-rated Stays",
        description = "Explore a world of exceptional stays at your fingertips. Whether it's a cozy boutique hotel or a luxurious villa, StayRater has got you covered!"
    )

    object Third : OnBoardingPage(
        image = R.drawable.happiness,
        title = "Say goodbye to uncertainty!",
        description = "Make informed decisions and book with confidence, knowing you're choosing from the best options available."
    )
}
