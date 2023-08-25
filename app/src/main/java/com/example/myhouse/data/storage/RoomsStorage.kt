package com.example.myhouse.data.storage

import com.example.myhouse.data.storage.local.rooms.RoomEntity

interface RoomsStorage {

    suspend fun insertRoom(roomEntity: RoomEntity): Boolean
    suspend fun getAllRooms(): List<RoomEntity>
}