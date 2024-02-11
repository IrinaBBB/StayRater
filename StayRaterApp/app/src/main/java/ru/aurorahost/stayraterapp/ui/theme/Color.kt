package ru.aurorahost.stayraterapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Dark = Color(0xFF00203F)
val Main = Color(0xFFADEFD1)
val MainDark = Color(0xFFADEFD1)
val Light = Color(0xFFF7FDFA)

val isLightTheme
    @Composable
    get() = !isSystemInDarkTheme()

val Colors.welcomeScreenBackgroundColor
    @Composable
    get() = if (isLightTheme) Light else Color.Black

val Colors.titleColor
    @Composable
    get() = if (isLightTheme) Dark else Main

val Colors.descriptionColor
    @Composable
    get() = if (isLightTheme) Dark.copy(alpha = 0.5f)
    else Main.copy(alpha = 0.5f)

val Colors.activeIndicatorColor
    @Composable
    get() = if (isLightTheme) Dark else Main

val Colors.inactiveIndicatorColor
    @Composable
    get() = if (isLightTheme) LightGray else Light

val Colors.buttonBackgroundColor
    @Composable
    get() = if (isLightTheme) Dark else Main

val Colors.buttonTextColor
    @Composable
    get() = if (isLightTheme) Light else Dark

val Colors.topAppBarContentColor: Color
    @Composable
    get() = if (isLightTheme) Light else Dark

val Colors.topAppBarBackgroundColor: Color
    @Composable
    get() = if (isLightTheme) Dark else Main
