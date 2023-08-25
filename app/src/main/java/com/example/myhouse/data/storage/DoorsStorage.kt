package com.example.myhouse.data.storage

import com.example.myhouse.data.storage.local.doors.DoorEntity
import com.example.myhouse.data.storage.network.dto.DoorsResponse

interface DoorsStorage {

    suspend fun getNetworkDoorsData(): DoorsResponse

    suspend fun insertDoors(doorEntity: DoorEntity): Boolean

    suspend fun updateDoorsName(doorEntity: DoorEntity): Boolean
    suspend fun getAllDoors(): List<DoorEntity>

}