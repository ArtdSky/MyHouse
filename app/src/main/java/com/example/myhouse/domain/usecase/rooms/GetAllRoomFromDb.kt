package com.example.myhouse.domain.usecase.rooms

import com.example.myhouse.domain.repository.RoomsRepository

class GetAllRoomFromDb(
    private val roomsRepository: RoomsRepository
) {
    suspend operator fun invoke() : List<String> {
        return roomsRepository.getAllRoomFromDb()
    }
}