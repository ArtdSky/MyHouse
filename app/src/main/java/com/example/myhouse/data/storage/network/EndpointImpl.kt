package com.example.myhouse.data.storage.network

import com.example.myhouse.data.storage.network.dto.CamerasResponse
import com.example.myhouse.data.storage.network.dto.DoorsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class EndpointImpl(
    private val client: HttpClient
) : NetworkEndpoints {

    override suspend fun getAllCamerasData(): CamerasResponse {
        return client.get { url(Routes.CAMERAS) }.body()
    }

    override suspend fun getAllDoorsData(): DoorsResponse {
        return client.get { url(Routes.DOORS) }.body()

    }
}