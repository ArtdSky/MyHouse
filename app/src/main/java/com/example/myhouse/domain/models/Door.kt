package com.example.myhouse.domain.models



data class Door(
    val name: String,
    val room: String?,
    val id: Int,
    val favorites: Boolean,
    val snapshot: String? = null
)

