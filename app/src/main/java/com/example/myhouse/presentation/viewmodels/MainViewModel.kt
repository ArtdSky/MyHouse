package com.example.myhouse.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.domain.usecase.cameras.GetAllCameras
import com.example.myhouse.domain.usecase.cameras.GetAllRooms
import com.example.myhouse.domain.usecase.doors.GetAllDoors
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllCameras: GetAllCameras,
    private val getAllRooms: GetAllRooms,
    private val getAllDoors: GetAllDoors
) : ViewModel() {

    private val TAG = "TAG-VM"
    init {
        getCameras()
    }

    fun getDoors(){
        viewModelScope.launch {
            val res = getAllDoors()
            Log.d(TAG, res.toString())
        }
    }

    fun getRooms(){
        viewModelScope.launch {
            val res = getAllRooms()
            Log.d(TAG, res.toString())
        }
    }

    fun getCameras(){
        viewModelScope.launch {
            val res = getAllCameras()
            Log.d(TAG, res.toString())
        }
    }
}