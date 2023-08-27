package com.example.myhouse.domain.usecase.doors

import com.example.myhouse.domain.models.Door
import com.example.myhouse.domain.repository.DoorsRepository

class InsertDoorsToDb(
    private val doorsRepository: DoorsRepository
) {

    suspend operator fun invoke(door: Door) : Boolean{
        return doorsRepository.insertDoorsToDb(door)
    }

}