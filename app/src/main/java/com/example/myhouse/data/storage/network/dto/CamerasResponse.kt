package com.example.myhouse.data.storage.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class CamerasResponse(
    val success: Boolean,
    val data: RoomData
)

@Serializable
data class Camera(
    val name: String,
    val snapshot: String,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val rec: Boolean
)

@Serializable
data class RoomData(
    val room: List<String>,
    val cameras: List<Camera>
)


