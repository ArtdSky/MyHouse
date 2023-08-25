package com.example.myhouse.domain.usecase.cameras

import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.repository.CamerasRepository

class GetAllCameras(
    private val camerasRepository: CamerasRepository
) {

    suspend operator fun invoke() : List<Camera> {
        return camerasRepository.getAllCameras()
    }
}