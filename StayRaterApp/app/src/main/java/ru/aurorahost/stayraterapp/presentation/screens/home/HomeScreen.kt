package ru.aurorahost.stayraterapp.presentation.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import ru.aurorahost.stayraterapp.presentation.common.ListContent
import ru.aurorahost.stayraterapp.ui.theme.homeScreenBackgroundColor
import ru.aurorahost.stayraterapp.ui.theme.topAppBarBackgroundColor

@ExperimentalCoilApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHotels = homeViewModel.getAllHotels.collectAsLazyPagingItems()
    Log.d("LIST!!!", allHotels.itemCount.toString())

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        },
        content = {
            Surface(
                color = MaterialTheme.colors.homeScreenBackgroundColor,
                modifier = Modifier.fillMaxSize()
            ) {
                ListContent(
                    hotels = allHotels,
                    navController = navController
                )
            }
        }
    )
}