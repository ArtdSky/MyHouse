package com.example.myhouse.data.storage.local

import com.example.myhouse.data.storage.local.cameras.CameraEntity
import com.example.myhouse.data.storage.local.doors.DoorEntity
import com.example.myhouse.data.storage.local.rooms.RoomEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object ProvideRealm {

    private val config = RealmConfiguration.create(schema = setOf(
        DoorEntity::class,
        RoomEntity::class,
        CameraEntity::class,
    ))
    val realm: Realm = Realm.open(config)
}