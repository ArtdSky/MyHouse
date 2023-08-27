package com.example.myhouse.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myhouse.domain.models.Camera
import com.example.myhouse.presentation.navigation.Screen
import com.example.myhouse.presentation.screens.components.CameraCard
import com.example.myhouse.presentation.screens.components.EditCameraDialog
import com.example.myhouse.presentation.screens.components.Header
import com.example.myhouse.presentation.viewmodels.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun CamerasScreen(
    vm: MainViewModel,
    navController: NavHostController,
    currentScreen: Screen
) {
    val TAG = "TAG-CS"
    val state by vm.state.observeAsState()
    Log.d(TAG, state.toString())

    val pressedCardId = remember { mutableStateOf<Int?>(null) }
    val showDialog = remember { mutableStateOf(false) }
    val selectedCamera = remember { mutableStateOf<Camera?>(null) }

    val isRefreshing = remember { mutableStateOf(false) }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing.value),
        onRefresh = {
            vm.refreshRoomsData()
            vm.refreshCamerasData()
        },
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {

            if (showDialog.value) {
                EditCameraDialog(
                    camera = selectedCamera.value,
                    onConfirm = { updateCamera ->
                        vm.updateCameraName(updateCamera)

                    },
                    onDismiss = {
                        showDialog.value = false
                        selectedCamera.value = null
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

                state?.rooms?.forEach { room ->
                    item {
                        Text(
                            text = room ?: "",
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp)
                                .padding(top = 21.dp, bottom = 10.dp)
                        )
                    }
                    items(state?.cameras?.filter { it?.room == room } ?: emptyList()) { camera ->
                        camera?.let { cameraExists ->
                            CameraCard(
                                url = cameraExists.snapshot,
                                name = cameraExists.name,
                                id = cameraExists.id,
                                favorites = cameraExists.favorites,
                                rec = cameraExists.rec,
                                pressedCardId = pressedCardId,
                                onEditClick = { cardId ->
                                    val cameraToEdit = state?.cameras?.find { it?.id == cardId }
                                    if (cameraToEdit != null) {
                                        selectedCamera.value = cameraToEdit
                                        showDialog.value = true
                                    }
                                }
                            )
                        }
                    }
                }

                if (state?.rooms!!.isNotEmpty()) {
                    item {
                        Text(
                            text = "Неизвестные",
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 14.dp)
                                .padding(top = 21.dp, bottom = 10.dp)
                        )
                    }
                }


                items(state?.cameras?.filter { it?.room == null } ?: emptyList()) { camera ->
                    camera?.let { cameraExist ->
                        CameraCard(
                            url = cameraExist.snapshot,
                            name = cameraExist.name,
                            id = cameraExist.id,
                            favorites = cameraExist.favorites,
                            rec = cameraExist.rec,
                            pressedCardId = pressedCardId,
                            onEditClick = { cardId ->
                                val cameraToEdit = state?.cameras?.find { it?.id == cardId }
                                if (cameraToEdit != null) {
                                    selectedCamera.value = cameraToEdit
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




