package com.example.myhouse.data.repository

import com.example.myhouse.data.storage.DoorsStorage
import com.example.myhouse.data.utils.doorEntityToDoor
import com.example.myhouse.data.utils.doorToDomain
import com.example.myhouse.data.utils.doorToDoorEntity
import com.example.myhouse.domain.models.Door
import com.example.myhouse.domain.repository.DoorsRepository

class DoorsRepositoryImpl(
    private val doorsStorage: DoorsStorage
) : DoorsRepository {
    override suspend fun insertDoorsToDb(door: Door): Boolean {
        val doorEntity = doorToDoorEntity(door)
        return doorsStorage.insertDoors(doorEntity)
    }

    override suspend fun updateDoorsNameInDb(door: Door): Boolean {
        val doorEntity = doorToDoorEntity(door)
        return doorsStorage.updateDoorsName(doorEntity)
    }

    override suspend fun getAllDoorsInDb(): List<Door> {
        val doorsEntity = doorsStorage.getAllDoors()
        return doorsEntity.map { doorEntityToDoor(it) }
    }

    override suspend fun getAllNetworkDoors(): List<Door> {
        val res = doorsStorage.getNetworkDoorsData().data
        return res.map { doorToDomain(it) }
    }
}