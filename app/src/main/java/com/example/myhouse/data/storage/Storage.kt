package com.example.myhouse.data.storage

import com.example.myhouse.data.storage.network.NetworkEndpoints
import com.example.myhouse.data.storage.network.dto.CamerasResponse
import com.example.myhouse.data.storage.network.dto.DoorsResponse

class Storage(
    private val networkEndpoints: NetworkEndpoints
) : CamerasStorage, DoorsStorage{
    override suspend fun getNetworkCamerasData(): CamerasResponse {
        return networkEndpoints.getAllCamerasData()
    }

    override suspend fun getNetworkDoorsData(): DoorsResponse {
        return networkEndpoints.getAllDoorsData()
    }
}