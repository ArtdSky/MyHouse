package com.example.myhouse.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.domain.usecase.cameras.GetAllNetworkCameras
import com.example.myhouse.domain.usecase.cameras.GetAllNetworkRooms
import com.example.myhouse.domain.usecase.doors.GetAllNetworkDoors
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllNetworkCameras: GetAllNetworkCameras,
    private val getAllNetworkRooms: GetAllNetworkRooms,
    private val getAllNetworkDoors: GetAllNetworkDoors
) : ViewModel() {

    private val TAG = "TAG-VM"
    init {
        getCameras()
    }

    fun getDoors(){
        viewModelScope.launch {
            val res = getAllNetworkDoors()
            Log.d(TAG, res.toString())
        }
    }

    fun getRooms(){
        viewModelScope.launch {
            val res = getAllNetworkRooms()
            Log.d(TAG, res.toString())
        }
    }

    fun getCameras(){
        viewModelScope.launch {
            val res = getAllNetworkCameras()
            Log.d(TAG, res.toString())
        }
    }
}