package com.example.myhouse.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.example.myhouse.domain.usecase.cameras.GetAllCameras
import com.example.myhouse.domain.usecase.cameras.GetAllRooms
import com.example.myhouse.domain.usecase.doors.GetAllDoors

class MainViewModel(
    private val getAllCameras: GetAllCameras,
    private val getAllRooms: GetAllRooms,
    private val getAllDoors: GetAllDoors
) : ViewModel() {


}