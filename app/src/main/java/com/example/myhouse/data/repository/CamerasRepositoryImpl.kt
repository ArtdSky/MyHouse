package com.example.myhouse.data.repository

import com.example.myhouse.data.storage.CamerasStorage
import com.example.myhouse.data.utils.camerasToDomain
import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.repository.CamerasRepository

class CamerasRepositoryImpl(
  private val camerasStorage: CamerasStorage
) : CamerasRepository{
    override suspend fun getAllRooms(): List<String> {
        return camerasStorage.getNetworkCamerasData().data.room
    }

    override suspend fun getAllCameras(): List<Camera> {
        val res = camerasStorage.getNetworkCamerasData().data.cameras
        return res.map { camerasToDomain(it) }
    }
}