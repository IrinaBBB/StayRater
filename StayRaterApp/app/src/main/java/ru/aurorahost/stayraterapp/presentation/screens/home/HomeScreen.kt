package ru.aurorahost.stayraterapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ru.aurorahost.stayraterapp.presentation.components.RatingBar
import ru.aurorahost.stayraterapp.ui.theme.Main

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) {
        RatingBar(stars=6, rating = 4.5)
    }
}