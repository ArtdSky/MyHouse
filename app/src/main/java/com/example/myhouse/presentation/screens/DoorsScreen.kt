package com.example.myhouse.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myhouse.presentation.navigation.Screen
import com.example.myhouse.presentation.screens.components.DoorCard
import com.example.myhouse.presentation.screens.components.Header
import com.example.myhouse.presentation.viewmodels.MainViewModel

@Composable
fun DoorsScreen(
    vm: MainViewModel,
    navController: NavHostController,
    currentScreen: Screen
) {
    val TAG = "TAG-DS"
    val state by vm.state.observeAsState()
    Log.d(TAG, state.toString())

    val pressedCardId = remember { mutableStateOf<Int?>(null) }

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Header(
                    vm = vm,
                    navController = navController,
                    currentScreen = currentScreen
                )
            }

            state?.doors?.forEach { door ->
                item {
                    DoorCard(
                        name = door?.name ?: "",
                        url = door?.snapshot,
                        room = door?.room,
                        id = door?.id,
                        favorites = door?.favorites,
                        pressedCardId = pressedCardId
                    )
                }
            }
        }
    }
}

