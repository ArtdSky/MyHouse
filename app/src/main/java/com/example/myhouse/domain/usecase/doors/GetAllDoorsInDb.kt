package com.example.myhouse.domain.usecase.doors

import com.example.myhouse.domain.models.Door
import com.example.myhouse.domain.repository.DoorsRepository

class GetAllDoorsInDb(
    private val doorsRepository: DoorsRepository
) {

    suspend operator fun invoke() : List<Door>{
        return doorsRepository.getAllDoorsInDb()
    }

}