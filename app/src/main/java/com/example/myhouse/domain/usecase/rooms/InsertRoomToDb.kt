package com.example.myhouse.domain.usecase.rooms

import com.example.myhouse.domain.repository.RoomsRepository

class InsertRoomToDb(
    private val roomsRepository: RoomsRepository
) {
    suspend operator fun invoke(value: String): Boolean {
        return roomsRepository.insertRoomToDb(value)
    }
}