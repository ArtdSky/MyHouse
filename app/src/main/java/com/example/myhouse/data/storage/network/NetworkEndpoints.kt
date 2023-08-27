package com.example.myhouse.data.storage.network

import com.example.myhouse.data.storage.network.dto.CamerasResponse
import com.example.myhouse.data.storage.network.dto.DoorsResponse


interface NetworkEndpoints {

    suspend fun getAllCamerasData(): CamerasResponse

    suspend fun getAllDoorsData(): DoorsResponse

}