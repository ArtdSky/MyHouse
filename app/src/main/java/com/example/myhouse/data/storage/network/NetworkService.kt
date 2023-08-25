package com.example.myhouse.data.storage.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json

object NetworkService {


    val client  = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.BODY
        }
        install(ContentNegotiation) {
            json()
        }
    }
}