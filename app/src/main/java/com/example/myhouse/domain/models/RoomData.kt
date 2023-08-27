package com.example.myhouse.domain.models


data class RoomData(
    val room: List<String>,
    val cameras: List<Camera>
)

data class Camera(
    val name: String,
    val snapshot: String,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val rec: Boolean
)



