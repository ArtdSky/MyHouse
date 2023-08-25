package com.example.myhouse.domain.repository

import com.example.myhouse.domain.models.Camera

interface CamerasRepository {

    suspend fun getAllRooms(): List<String>

    suspend fun getAllCameras(): List<Camera>
}