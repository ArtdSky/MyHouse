package com.example.myhouse.domain.repository

import com.example.myhouse.domain.models.Doors

interface DoorsRepository {

    suspend fun getAllDoors(): List<Doors>
}