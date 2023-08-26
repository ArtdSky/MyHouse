package com.example.myhouse.domain.usecase.cameras

import com.example.myhouse.domain.repository.CamerasRepository

class ClearCamerasDb(
    private val camerasRepository: CamerasRepository
) {
    suspend operator fun invoke() : Boolean{
        return camerasRepository.clearCamerasDb()
    }
}