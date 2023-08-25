package com.example.myhouse.data.utils

import com.example.myhouse.data.storage.local.cameras.CameraEntity
import com.example.myhouse.data.storage.local.doors.DoorEntity
import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.models.Door
import com.example.myhouse.data.storage.network.dto.Camera as Cameras
import com.example.myhouse.data.storage.network.dto.Doors as Doores


fun cameraToDomain(camera: Cameras): Camera = camera.run {
    return Camera(
        name = name,
        snapshot = snapshot,
        room = room,
        id = id,
        favorites = favorites,
        rec = rec
    )
}

fun doorToDomain(doors: Doores): Door = doors.run {
    return Door(
        name = name,
        snapshot = snapshot,
        room = room,
        id = id,
        favorites = favorites,
    )
}

fun doorToDoorEntity(door: Door): DoorEntity {
    return DoorEntity().apply {
        name = door.name
        room = door.room
        id = door.id
        favorites = door.favorites
        snapshot = door.snapshot
    }
}

fun doorEntityToDoor(doorEntity: DoorEntity): Door {
    return Door(
        id = doorEntity.id ?: 0,
        name = doorEntity.name ?: "",
        room = doorEntity.room,
        favorites = doorEntity.favorites ?: false,
        snapshot = doorEntity.snapshot
    )
}

fun cameraToCameraEntity(camera: Camera): CameraEntity {
    return CameraEntity().apply {
        name = camera.name
        room = camera.room
        id = camera.id
        favorites = camera.favorites
        snapshot = camera.snapshot
        rec = camera.rec
    }
}

