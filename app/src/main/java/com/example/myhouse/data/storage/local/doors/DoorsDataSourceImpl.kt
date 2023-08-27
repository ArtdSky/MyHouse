package com.example.myhouse.data.storage.local.doors

import com.example.myhouse.data.storage.local.cameras.CameraEntity
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query

class DoorsDataSourceImpl(
    private val realm: Realm
) : DoorsDataSource {

    override suspend fun insertDoor(doorEntity: DoorEntity): Boolean {
        return try {
            realm.write {
                copyToRealm(doorEntity)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun updateDoorName(doorEntity: DoorEntity): Boolean {
        return try {
            realm.write {
                val queriedDoorEntity =
                    query<DoorEntity>(query = "id == $0", doorEntity.id).first().find()
                queriedDoorEntity?.name = doorEntity.name
            }
            true
        } catch (e: Exception) {
            false
        }
    }


    override suspend fun getAllDoors(): List<DoorEntity> {
        return realm.query<DoorEntity>().find()
    }

    override suspend fun clearDoorsDb(): Boolean {
        return try {
            realm.write {
                val res = query<DoorEntity>().find()
                delete(res)
            }
            true
        } catch (e: Exception) {
            false
        }
    }


}