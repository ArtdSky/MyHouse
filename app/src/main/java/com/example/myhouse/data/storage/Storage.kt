package com.example.myhouse.data.storage

import com.example.myhouse.data.storage.local.cameras.CameraEntity
import com.example.myhouse.data.storage.local.cameras.CamerasDataSource
import com.example.myhouse.data.storage.local.doors.DoorEntity
import com.example.myhouse.data.storage.local.doors.DoorsDataSource
import com.example.myhouse.data.storage.local.rooms.RoomDataSource
import com.example.myhouse.data.storage.local.rooms.RoomEntity
import com.example.myhouse.data.storage.network.NetworkEndpoints
import com.example.myhouse.data.storage.network.dto.CamerasResponse
import com.example.myhouse.data.storage.network.dto.DoorsResponse

class Storage(
    private val networkEndpoints: NetworkEndpoints,
    private val camerasDataSource: CamerasDataSource,
    private val doorsDataSource: DoorsDataSource,
    private val roomDataSource: RoomDataSource,
) : CamerasStorage, DoorsStorage, RoomsStorage {

    override suspend fun insertRoom(roomEntity: RoomEntity): Boolean {
        return roomDataSource.insertRoom(roomEntity)
    }

    override suspend fun getAllRooms(): List<RoomEntity> {
        return roomDataSource.getAllRooms()
    }

    override suspend fun getNetworkCamerasData(): CamerasResponse {
        return networkEndpoints.getAllCamerasData()
    }

    override suspend fun insertCameras(camerasEntity: CameraEntity): Boolean {
        return camerasDataSource.insertCameras(camerasEntity)
    }

    override suspend fun insertDoors(doorEntity: DoorEntity): Boolean {
        return doorsDataSource.insertDoor(doorEntity)
    }

    override suspend fun updateDoorsName(doorEntity: DoorEntity): Boolean {
        return doorsDataSource.updateDoorName(doorEntity)
    }

    override suspend fun getAllDoors(): List<DoorEntity> {
        return doorsDataSource.getAllDoors()
    }

    override suspend fun updateCameraName(cameraEntity: CameraEntity): Boolean {
        return camerasDataSource.updateCameraName(cameraEntity)
    }

    override suspend fun getAllCameras(): List<CameraEntity> {
        return camerasDataSource.getAllCameras()
    }

    override suspend fun getNetworkDoorsData(): DoorsResponse {
        return networkEndpoints.getAllDoorsData()
    }
}