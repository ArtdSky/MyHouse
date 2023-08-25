package com.example.myhouse.presentation.di

import com.example.myhouse.data.repository.CamerasRepositoryImpl
import com.example.myhouse.data.repository.DoorsRepositoryImpl
import com.example.myhouse.data.storage.CamerasStorage
import com.example.myhouse.data.storage.DoorsStorage
import com.example.myhouse.data.storage.Storage
import com.example.myhouse.data.storage.network.EndpointImpl
import com.example.myhouse.data.storage.network.NetworkEndpoints
import com.example.myhouse.data.storage.network.NetworkService
import com.example.myhouse.domain.repository.CamerasRepository
import com.example.myhouse.domain.repository.DoorsRepository
import com.example.myhouse.domain.usecase.cameras.GetAllCameras
import com.example.myhouse.domain.usecase.cameras.GetAllRooms
import com.example.myhouse.domain.usecase.doors.GetAllDoors
import com.example.myhouse.presentation.viewmodels.MainViewModel
import io.ktor.client.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DependencyInjection = module {

    //Data
    single  <HttpClient>{ NetworkService.client }
    single<NetworkEndpoints> { EndpointImpl(get()) }

    single<CamerasStorage> { Storage(get()) }
    single<DoorsStorage> { Storage(get()) }

    single<CamerasRepository> { CamerasRepositoryImpl(get()) }
    single<DoorsRepository> { DoorsRepositoryImpl(get()) }

    //Usecases
    factory { GetAllDoors(get()) }
    factory { GetAllCameras(get()) }
    factory { GetAllRooms(get()) }


    // View Model
    viewModel {
        MainViewModel(
            get(),
            get(),
            get(),

        )
    }

}