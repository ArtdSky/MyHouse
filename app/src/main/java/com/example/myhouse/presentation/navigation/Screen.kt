package com.example.myhouse.presentation.navigation


sealed class Screen(val route: String) {
    object Cameras : Screen("cameras_screen")
    object Doors : Screen("doors_screen")

}

val AppTabRowScreens = listOf(
    Screen.Cameras,
    Screen.Doors,
)