package com.example.myhouse.domain.repository

interface RoomsRepository {


    suspend fun insertRoomToDb(value: String): Boolean
    suspend fun getAllRoomFromDb(): List<String>
}