package com.example.myhouse.data.storage.local.rooms

interface RoomDataSource {

    suspend fun insertRoom(roomEntity: RoomEntity): Boolean
    suspend fun getAllRooms(): List<RoomEntity>

}