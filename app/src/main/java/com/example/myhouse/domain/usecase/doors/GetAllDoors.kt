package com.example.myhouse.domain.usecase.doors

import com.example.myhouse.domain.models.Doors
import com.example.myhouse.domain.repository.DoorsRepository

class GetAllDoors(
    private val doorsRepository: DoorsRepository
) {

    suspend fun invoke() : List<Doors>{
        return doorsRepository.getAllDoors()
    }

}