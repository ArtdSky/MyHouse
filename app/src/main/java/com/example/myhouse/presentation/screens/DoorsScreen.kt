package com.example.myhouse.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myhouse.domain.models.Door
import com.example.myhouse.presentation.navigation.Screen
import com.example.myhouse.presentation.screens.components.DoorCard
import com.example.myhouse.presentation.screens.components.EditDoorDialog
import com.example.myhouse.presentation.screens.components.Header
import com.example.myhouse.presentation.viewmodels.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

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
    val showDialog = remember { mutableStateOf(false) }
    val selectedDoor = remember { mutableStateOf<Door?>(null) }

    val isRefreshing = remember { mutableStateOf(false) }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing.value),
        onRefresh = {
            vm.refreshDoorsData()
        },
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            if (showDialog.value) {
                EditDoorDialog(
                    door = selectedDoor.value,
                    onConfirm = { updatedDoor ->
                        vm.updateDoorName(updatedDoor)

                    },
                    onDismiss = {
                        showDialog.value = false
                        selectedDoor.value = null
                    }
                )
            }
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
                            pressedCardId = pressedCardId,
                            onEditClick = { cardId ->
                                val doorToEdit = state?.doors?.find { it?.id == cardId }
                                if (doorToEdit != null) {
                                    selectedDoor.value = doorToEdit
                                    showDialog.value = true
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


