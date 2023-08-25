package com.example.myhouse.domain.usecase.cameras

import com.example.myhouse.domain.repository.CamerasRepository

class GetAllRooms(
    private val camerasRepository: CamerasRepository
) {

    suspend operator fun invoke() : List<String> {
        return camerasRepository.getAllRooms()
    }
}