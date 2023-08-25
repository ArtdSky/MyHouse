package com.example.myhouse.data.repository

import com.example.myhouse.data.storage.DoorsStorage
import com.example.myhouse.data.utils.doorsToDomain
import com.example.myhouse.domain.models.Doors
import com.example.myhouse.domain.repository.DoorsRepository

class DoorsRepositoryImpl(
    private val doorsStorage: DoorsStorage
) : DoorsRepository {
    override suspend fun getAllDoors(): List<Doors> {
        val res = doorsStorage.getNetworkDoorsData().data
        return res.map { doorsToDomain(it) }
    }
}