package com.example.myhouse.data.storage.local.rooms

import com.example.myhouse.data.storage.local.cameras.CameraEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query

class RoomDataSourceImpl(
    private val realm: Realm
) : RoomDataSource {

    override suspend fun insertRoom(roomEntity: RoomEntity): Boolean {
        return try {
            realm.write {
                copyToRealm(roomEntity)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getAllRooms(): List<RoomEntity> {
        return realm.query<RoomEntity>().find()
    }

    override suspend fun clearRoomsDb(): Boolean {
        return try {
            realm.write {
                val res = query<RoomEntity>().find()
                delete(res)
            }
            true
        } catch (e: Exception) {
            false
        }
    }


}