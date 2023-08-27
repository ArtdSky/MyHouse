package com.example.myhouse.data.storage.local.cameras

interface CamerasDataSource {

    suspend fun insertCameras(cameraEntity: CameraEntity): Boolean
    suspend fun updateCameraName(cameraEntity: CameraEntity): Boolean
    suspend fun getAllCameras(): List<CameraEntity>

    suspend fun clearCamerasDb(): Boolean


}