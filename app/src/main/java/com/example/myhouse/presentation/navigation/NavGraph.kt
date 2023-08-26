package com.example.myhouse.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myhouse.presentation.screens.CamerasScreen
import com.example.myhouse.presentation.screens.DoorsScreen
import com.example.myhouse.presentation.viewmodels.MainViewModel


@Composable
fun NavGraph(
    vm: MainViewModel,
    navController: NavHostController,
    currentScreen: Screen
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Cameras.route
    ) {
        composable(route = Screen.Cameras.route) {
            CamerasScreen(
                vm = vm,
                navController = navController,
                currentScreen = currentScreen
            )
        }

        composable(route = Screen.Doors.route) {
            DoorsScreen(
                vm = vm,
                navController = navController,
                currentScreen = currentScreen
            )
        }
    }

}