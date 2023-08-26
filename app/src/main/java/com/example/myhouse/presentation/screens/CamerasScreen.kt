package com.example.myhouse.presentation.screens

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myhouse.presentation.navigation.Screen
import com.example.myhouse.presentation.viewmodels.MainViewModel

@Composable
fun CamerasScreen(
    vm: MainViewModel,
    navController: NavHostController,
    currentScreen : Screen
){
    val viewModelState = vm.state.value
    Log.d("TAG-CS", viewModelState.toString())

    Text(text = "QQ")

}