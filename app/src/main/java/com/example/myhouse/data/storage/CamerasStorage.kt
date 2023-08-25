package com.example.myhouse.data.storage

import com.example.myhouse.data.storage.network.dto.CamerasResponse

interface CamerasStorage {

    suspend fun getNetworkCamerasData(): CamerasResponse
}