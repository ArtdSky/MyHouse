package com.example.myhouse.data.repository

import com.example.myhouse.data.storage.RoomsStorage
import com.example.myhouse.data.storage.local.rooms.RoomEntity
import com.example.myhouse.domain.repository.RoomsRepository

class RoomRepositoryImpl(
    private val roomsStorage: RoomsStorage

) : RoomsRepository {
    override suspend fun insertRoomToDb(value: String): Boolean {
        return roomsStorage.insertRoom(RoomEntity().apply {
            name = value
        })
    }

    override suspend fun getAllRoomFromDb(): List<String> {
        val roomEntitys = roomsStorage.getAllRooms()
        return roomEntitys.map { it.name.toString() }
    }
}