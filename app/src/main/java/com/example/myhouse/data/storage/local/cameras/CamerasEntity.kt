package com.example.myhouse.data.storage.local.cameras

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


open class CameraEntity : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId.invoke()
    var id: Int? = null
    var name: String? = null
    var room: String? = null
    var favorites: Boolean? = null
    var snapshot: String? = null
    var rec: Boolean? = null
}

