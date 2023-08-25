package com.example.myhouse.data.utils

import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.models.Doors
import com.example.myhouse.data.storage.network.dto.Camera as Cameras
import com.example.myhouse.data.storage.network.dto.Doors as Doores



fun camerasToDomain(camera: Cameras): Camera = camera.run {
    return Camera(
        name = name,
        snapshot = snapshot,
        room = room,
        id = id,
        favorites = favorites,
        rec = rec
    )
}

fun doorsToDomain(doors: Doores): Doors = doors.run {
    return Doors(
        name = name,
        snapshot = snapshot,
        room = room,
        id = id,
        favorites = favorites,
    )
}