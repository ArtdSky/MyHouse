package com.example.myhouse.domain.usecase.rooms

import com.example.myhouse.domain.repository.RoomsRepository

class ClearRoomsDb(
    private val roomsRepository: RoomsRepository
) {
    suspend operator fun invoke(): Boolean {
        return roomsRepository.clearRoomsDb()
    }
}