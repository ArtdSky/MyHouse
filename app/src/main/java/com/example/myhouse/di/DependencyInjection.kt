package com.example.myhouse.di

import com.example.myhouse.data.repository.CamerasRepositoryImpl
import com.example.myhouse.data.repository.DoorsRepositoryImpl
import com.example.myhouse.data.storage.CamerasStorage
import com.example.myhouse.data.storage.DoorsStorage
import com.example.myhouse.data.storage.Storage
import com.example.myhouse.data.storage.local.doors.DoorsDataSource
import com.example.myhouse.data.storage.local.ProvideRealm
import com.example.myhouse.data.storage.local.doors.DoorsDataSourceImpl
import com.example.myhouse.data.storage.network.EndpointImpl
import com.example.myhouse.data.storage.network.NetworkEndpoints
import com.example.myhouse.data.storage.network.NetworkService
import com.example.myhouse.domain.repository.CamerasRepository
import com.example.myhouse.domain.repository.DoorsRepository
import com.example.myhouse.domain.usecase.cameras.GetAllNetworkCameras
import com.example.myhouse.domain.usecase.cameras.GetAllNetworkRooms
import com.example.myhouse.domain.usecase.doors.GetAllNetworkDoors
import com.example.myhouse.presentation.viewmodels.MainViewModel
import io.ktor.client.HttpClient
import io.realm.kotlin.Realm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DependencyInjection = module {

    //Data
    single<Realm> { ProvideRealm.realm }
    single<DoorsDataSource> { DoorsDataSourceImpl(get()) }

    single  <HttpClient>{ NetworkService.client }
    single<NetworkEndpoints> { EndpointImpl(get()) }

    single<CamerasStorage> { Storage(get()) }
    single<DoorsStorage> { Storage(get()) }

    single<CamerasRepository> { CamerasRepositoryImpl(get()) }
    single<DoorsRepository> { DoorsRepositoryImpl(get()) }

    //Usecases
    factory { GetAllNetworkDoors(get()) }
    factory { GetAllNetworkCameras(get()) }
    factory { GetAllNetworkRooms(get()) }


    // View Model
    viewModel {
        MainViewModel(
            get(),
            get(),
            get(),

        )
    }

}