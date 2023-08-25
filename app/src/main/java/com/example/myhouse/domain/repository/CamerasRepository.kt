package com.example.myhouse.domain.repository


import com.example.myhouse.domain.models.Camera

interface CamerasRepository {

    suspend fun getAllNetworkRooms(): List<String>

    suspend fun getAllNetworkCameras(): List<Camera>


    suspend fun insertCamerasToDb(camera: Camera): Boolean
    suspend fun updateCameraNameInDb(camera: Camera): Boolean
    suspend fun getAllCamerasFromDb(): List<Camera>
}