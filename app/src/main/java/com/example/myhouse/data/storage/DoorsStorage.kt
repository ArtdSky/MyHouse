package com.example.myhouse.data.storage

import com.example.myhouse.data.storage.network.dto.DoorsResponse

interface DoorsStorage {

    suspend fun getNetworkDoorsData(): DoorsResponse

}