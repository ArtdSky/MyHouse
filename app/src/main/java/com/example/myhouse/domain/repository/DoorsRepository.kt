package com.example.myhouse.domain.repository

import com.example.myhouse.domain.models.Door

interface DoorsRepository {

    suspend fun getAllNetworkDoors(): List<Door>

    suspend fun insertDoorsToDb(door: Door): Boolean

    suspend fun updateDoorsNameInDb(door: Door): Boolean

    suspend fun getAllDoorsInDb(): List<Door>

    suspend fun clearDoorsDb(): Boolean

}