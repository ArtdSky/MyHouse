package com.example.myhouse.domain.usecase.cameras

import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.repository.CamerasRepository

class InsertCameraToDb(
    private val camerasRepository: CamerasRepository
) {

    suspend operator fun invoke(camera: Camera) : Boolean {
        return camerasRepository.insertCamerasToDb(camera)
    }
}