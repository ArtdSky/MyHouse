package com.example.myhouse.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myhouse.presentation.navigation.Screen
import com.example.myhouse.presentation.screens.components.CameraCard
import com.example.myhouse.presentation.screens.components.Header
import com.example.myhouse.presentation.viewmodels.MainViewModel

@Composable
fun CamerasScreen(
    vm: MainViewModel,
    navController: NavHostController,
    currentScreen: Screen
) {
    val TAG = "TAG-CS"
    val state by vm.state.observeAsState()
    Log.d(TAG, state.toString())
    Surface(modifier = Modifier.fillMaxSize()) {
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
                    camera?.let {
                        CameraCard(
                            url = it.snapshot,
                            name = it.name,
                            id = it.id,
                            favorites = it.favorites,
                            rec = it.rec
                        )
                    }
                }
            }
            
            if(state?.rooms!!.isNotEmpty()){
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
                camera?.let {
                    CameraCard(
                        url = it.snapshot,
                        name = it.name,
                        id = it.id,
                        favorites = it.favorites,
                        rec = it.rec
                    )
                }
            }
        }
    }
}




