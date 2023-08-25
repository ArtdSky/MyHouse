package com.example.myhouse.data.repository

import com.example.myhouse.data.storage.CamerasStorage
import com.example.myhouse.data.utils.cameraToCameraEntity
import com.example.myhouse.data.utils.cameraToDomain
import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.repository.CamerasRepository

class CamerasRepositoryImpl(
  private val camerasStorage: CamerasStorage
) : CamerasRepository{

    override suspend fun getAllNetworkRooms(): List<String> {
        return camerasStorage.getNetworkCamerasData().data.room
    }
    override suspend fun getAllNetworkCameras(): List<Camera> {
        val res = camerasStorage.getNetworkCamerasData().data.cameras
        return res.map { cameraToDomain(it) }
    }

    override suspend fun insertCamerasToDb(camera: Camera): Boolean {
        val cameraEntity = cameraToCameraEntity(camera)
        return camerasStorage.insertCameras(cameraEntity)
    }

    override suspend fun updateCameraNameInDb(camera: Camera): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getAllCamerasFromDb(): List<Camera> {
        TODO("Not yet implemented")
    }
}