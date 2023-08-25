package com.example.myhouse.data.storage

import com.example.myhouse.data.storage.local.cameras.CameraEntity
import com.example.myhouse.data.storage.network.dto.CamerasResponse

interface CamerasStorage {

    suspend fun getNetworkCamerasData(): CamerasResponse

    suspend fun insertCameras(camerasEntity: CameraEntity): Boolean
    suspend fun updateCameraName(cameraEntity: CameraEntity): Boolean
    suspend fun getAllCameras(): List<CameraEntity>
}