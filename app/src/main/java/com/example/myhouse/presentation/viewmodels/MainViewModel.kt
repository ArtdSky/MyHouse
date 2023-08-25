package com.example.myhouse.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.domain.usecase.cameras.GetAllCamerasFromDb
import com.example.myhouse.domain.usecase.cameras.GetAllNetworkCameras
import com.example.myhouse.domain.usecase.cameras.GetAllNetworkRooms
import com.example.myhouse.domain.usecase.cameras.InsertCameraToDb
import com.example.myhouse.domain.usecase.cameras.UpdateCameraNameInDb
import com.example.myhouse.domain.usecase.doors.GetAllDoorsInDb
import com.example.myhouse.domain.usecase.doors.GetAllNetworkDoors
import com.example.myhouse.domain.usecase.doors.InsertDoorsToDb
import com.example.myhouse.domain.usecase.doors.UpdateDoorsNameInDb
import com.example.myhouse.domain.usecase.rooms.GetAllRoomFromDb
import com.example.myhouse.domain.usecase.rooms.InsertRoomToDb
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllNetworkCameras: GetAllNetworkCameras,
    private val getAllNetworkRooms: GetAllNetworkRooms,
    private val getAllCamerasFromDb: GetAllCamerasFromDb,
    private val insertCameraToDb: InsertCameraToDb,
    private val updateCameraNameInDb: UpdateCameraNameInDb,
    private val getAllNetworkDoors: GetAllNetworkDoors,
    private val getAllDoorsInDb: GetAllDoorsInDb,
    private val insertDoorsToDb: InsertDoorsToDb,
    private val updateDoorsNameInDb: UpdateDoorsNameInDb,
    private val getAllRoomFromDb: GetAllRoomFromDb,
    private val insertRoomToDb: InsertRoomToDb
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