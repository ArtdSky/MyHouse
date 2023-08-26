package com.example.myhouse.presentation.state

import com.example.myhouse.domain.models.Camera
import com.example.myhouse.domain.models.Door


data class ViewModelState(
    val doors: List<Door?> = emptyList(),
    val cameras: List<Camera?> = emptyList(),
    val rooms: List<String?> = emptyList(),
)