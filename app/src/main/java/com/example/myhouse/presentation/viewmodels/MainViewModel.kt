package com.example.myhouse.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.models.Door
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
import com.example.myhouse.presentation.state.ViewModelState
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
//        getDoorsFromDb()
    }

    private val _state = MutableLiveData(ViewModelState())
    val state: LiveData<ViewModelState> get() = _state

    fun getDoorsFromNetwork() {
        viewModelScope.launch {
            try {
                val res: List<Door> = getAllNetworkDoors()
                _state.value = state.value?.copy(doors = res)
            } catch (exception: Exception) {
                Log.d(TAG, "Error in getDoorsFromNetwork: ${exception.message}")
            }
        }
    }
    fun getCamerasFromNetwork() {
        viewModelScope.launch {
            try {
                val res: List<Camera> = getAllNetworkCameras()
                _state.value = state.value?.copy(cameras = res)
            } catch (exception: Exception) {
                Log.d(TAG, "Error in getCamerasFromNetwork: ${exception.message}")
            }
        }
    }
    fun getRoomsFromNetwork() {
        viewModelScope.launch {
            try {
                val res: List<String> = getAllNetworkRooms()
                _state.value = state.value?.copy(rooms = res)
            } catch (exception: Exception) {
                Log.d(TAG, "Error in getRoomsFromNetwork: ${exception.message}")
            }
        }
    }

    fun getDoorsFromDb() {
        viewModelScope.launch {
            try {
                val res: List<Door> = getAllDoorsInDb()
                _state.value = state.value?.copy(doors = res)
            } catch (exception: Exception) {
                Log.d(TAG, "Error in getDoorsFromDb: ${exception.message}")
            }
        }
    }

    fun getCamerasFromDb() {
        viewModelScope.launch {
            try {
                val res: List<Camera> = getAllCamerasFromDb()
                _state.value = state.value?.copy(cameras = res)
            } catch (exception: Exception) {
                Log.d(TAG, "Error in getCamerasFromDb: ${exception.message}")
            }
        }
    }
    fun getRoomsFromDb() {
        viewModelScope.launch {
            try {
                val res: List<String> = getAllRoomFromDb()
                _state.value = state.value?.copy(rooms = res)
            } catch (exception: Exception) {
                Log.d(TAG, "Error in getRoomsFromNetwork: ${exception.message}")
            }
        }
    }

    fun addDoorsToDb() {
        viewModelScope.launch {
            try {
                _state.value?.doors?.forEach{
                    if (it != null) {
                        insertDoorsToDb( it  )
                    }
                }
            } catch (exception: Exception) {
                Log.d(TAG, "Error in addtDoorsToDb: ${exception.message}")
            }
        }
    }

    fun addCamerasToDb() {
        viewModelScope.launch {
            try {
                _state.value?.cameras?.forEach{
                    if (it != null) {
                        insertCameraToDb( it  )
                    }
                }
            } catch (exception: Exception) {
                Log.d(TAG, "Error in addCamerasToDb: ${exception.message}")
            }
        }
    }

    fun addRoomsToDb() {
        viewModelScope.launch {
            try {
                _state.value?.rooms?.forEach{
                    if (it != null) {
                        insertRoomToDb( it  )
                    }
                }
            } catch (exception: Exception) {
                Log.d(TAG, "Error in addRoomsToDb: ${exception.message}")
            }
        }
    }

    fun updateDoorName(door: Door) {
        viewModelScope.launch {
            try {
                updateDoorsNameInDb( door )
            } catch (exception: Exception) {
                Log.d(TAG, "Error in updateDoorName: ${exception.message}")
            }
        }
    }

    fun updateCameraName(camera: Camera) {
        viewModelScope.launch {
            try {
                updateCameraNameInDb( camera )
            } catch (exception: Exception) {
                Log.d(TAG, "Error in updateCameraName: ${exception.message}")
            }
        }
    }



}