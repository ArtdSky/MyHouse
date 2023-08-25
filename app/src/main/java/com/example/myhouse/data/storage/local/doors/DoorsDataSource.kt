package com.example.myhouse.data.storage.local.doors

interface DoorsDataSource {

    suspend fun insertDoor(doorEntity: DoorEntity): Boolean

    suspend fun updateDoorName(doorEntity: DoorEntity): Boolean
    suspend fun getAllDoors(): List<DoorEntity>

}