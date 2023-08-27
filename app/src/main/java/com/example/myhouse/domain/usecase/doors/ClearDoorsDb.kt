package com.example.myhouse.domain.usecase.doors

import com.example.myhouse.domain.repository.DoorsRepository

class ClearDoorsDb(
    private val doorsRepository: DoorsRepository
) {
    suspend operator fun invoke() : Boolean{
        return doorsRepository.clearDoorsDb()
    }
}