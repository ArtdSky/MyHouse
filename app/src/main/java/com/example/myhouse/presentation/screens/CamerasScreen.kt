package com.example.myhouse.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myhouse.presentation.navigation.Screen
import com.example.myhouse.presentation.viewmodels.MainViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier

@Composable
fun CamerasScreen(
    vm: MainViewModel,
    navController: NavHostController,
    currentScreen : Screen
){
    val viewModelState by vm.state.observeAsState()
    Log.d("TAG-CS", viewModelState.toString())

    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Text(text = viewModelState?.cameras?.size.toString())
            Text(text = viewModelState?.doors?.size.toString())
            Text(text = viewModelState?.rooms?.size.toString())

            Button(onClick = {
                vm.refreshDoorsData()
                vm.refreshCamerasData()
                vm.refreshRoomsData()
            }) {
                Text(text = "UPDATE")
            }
        }
    }


}