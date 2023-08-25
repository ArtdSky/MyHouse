package com.example.myhouse.data.storage.local

import com.example.myhouse.data.storage.local.doors.DoorEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object ProvideRealm {

    private val config = RealmConfiguration.create(schema = setOf(DoorEntity::class))
    val realm: Realm = Realm.open(config)
}