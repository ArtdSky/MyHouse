package com.example.myhouse.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myhouse.presentation.viewmodels.MainViewModel


@Composable
fun NavState(
    vm: MainViewModel
) {

    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = AppTabRowScreens.find {
        it.route == currentDestination?.route
    } ?: Screen.Cameras

    NavGraph(
        vm = vm,
        navController = navController,
        currentScreen = currentScreen
    )

}