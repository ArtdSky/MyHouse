package com.example.myhouse.data.storage.local.cameras

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query

class CamerasDataSourceImpl(
    private val realm: Realm
) : CamerasDataSource {
    override suspend fun insertCameras(cameraEntity: CameraEntity): Boolean {
        return try {
            realm.write {
                copyToRealm(cameraEntity)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun updateCameraName(cameraEntity: CameraEntity): Boolean {
        return try {
            realm.write {
                val queriedDoor =
                    query<CameraEntity>(query = "id == $0", cameraEntity.id).first().find()
                queriedDoor?.name = cameraEntity.name
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun getAllCameras(): List<CameraEntity> {
        return realm.query<CameraEntity>().find()
    }

    override suspend fun clearCamerasDb(): Boolean {
        return try {
            realm.write {
                val res = query<CameraEntity>().find()
                delete(res)
            }
            true
        } catch (e: Exception) {
            false
        }
    }
}