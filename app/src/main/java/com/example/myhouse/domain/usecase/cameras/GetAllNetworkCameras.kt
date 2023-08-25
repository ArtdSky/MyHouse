package com.example.myhouse.domain.usecase.cameras

import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.repository.CamerasRepository

class GetAllNetworkCameras(
    private val camerasRepository: CamerasRepository
) {

    suspend operator fun invoke() : List<Camera> {
        return camerasRepository.getAllNetworkCameras()
    }
}