package com.example.myhouse.domain.usecase.cameras

import com.example.myhouse.domain.models.RoomData
import com.example.myhouse.domain.repository.CamerasRepository

class GetAllRooms(
    private val camerasRepository: CamerasRepository
) {

    suspend fun invoke() : List<String> {
        return camerasRepository.getAllRooms()
    }
}