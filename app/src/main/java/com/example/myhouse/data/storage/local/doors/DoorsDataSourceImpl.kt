package com.example.myhouse.data.storage.local.doors

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
                    query<DoorEntity>(query = "_id == $0", doorEntity.id).first().find()
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


}