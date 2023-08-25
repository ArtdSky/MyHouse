package com.example.myhouse.domain.repository

import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.models.RoomData
interface CamerasRepository {

    suspend fun getAllRooms() : List<String>

    suspend fun getAllCameras() : List<Camera>
}