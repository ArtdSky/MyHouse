package com.example.myhouse.data.storage.network.dto

import kotlinx.serialization.Serializable


@Serializable
data class DoorsResponse(
    val success: Boolean,
    val data: List<Doors>
)

@Serializable
data class Doors(
    val name: String,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val snapshot: String? = null
)

