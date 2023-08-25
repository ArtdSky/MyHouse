package com.example.myhouse.di

import com.example.myhouse.data.repository.CamerasRepositoryImpl
import com.example.myhouse.data.repository.DoorsRepositoryImpl
import com.example.myhouse.data.repository.RoomRepositoryImpl
import com.example.myhouse.data.storage.CamerasStorage
import com.example.myhouse.data.storage.DoorsStorage
import com.example.myhouse.data.storage.RoomsStorage
import com.example.myhouse.data.storage.Storage
import com.example.myhouse.data.storage.local.doors.DoorsDataSource
import com.example.myhouse.data.storage.local.ProvideRealm
import com.example.myhouse.data.storage.local.cameras.CamerasDataSource
import com.example.myhouse.data.storage.local.cameras.CamerasDataSourceImpl
import com.example.myhouse.data.storage.local.doors.DoorsDataSourceImpl
import com.example.myhouse.data.storage.local.rooms.RoomDataSource
import com.example.myhouse.data.storage.local.rooms.RoomDataSourceImpl
import com.example.myhouse.data.storage.network.EndpointImpl
import com.example.myhouse.data.storage.network.NetworkEndpoints
import com.example.myhouse.data.storage.network.NetworkService
import com.example.myhouse.domain.repository.CamerasRepository
import com.example.myhouse.domain.repository.DoorsRepository
import com.example.myhouse.domain.repository.RoomsRepository
import com.example.myhouse.domain.usecase.cameras.GetAllCamerasFromDb
import com.example.myhouse.domain.usecase.cameras.GetAllNetworkCameras
import com.example.myhouse.domain.usecase.cameras.GetAllNetworkRooms
import com.example.myhouse.domain.usecase.cameras.InsertCameraToDb
import com.example.myhouse.domain.usecase.cameras.UpdateCameraNameInDb
import com.example.myhouse.domain.usecase.doors.GetAllDoorsInDb
import com.example.myhouse.domain.usecase.doors.GetAllNetworkDoors
import com.example.myhouse.domain.usecase.doors.InsertDoorsToDb
import com.example.myhouse.domain.usecase.doors.UpdateDoorsNameInDb
import com.example.myhouse.domain.usecase.rooms.GetAllRoomFromDb
import com.example.myhouse.domain.usecase.rooms.InsertRoomToDb
import com.example.myhouse.presentation.viewmodels.MainViewModel
import io.ktor.client.HttpClient
import io.realm.kotlin.Realm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DependencyInjection = module {

    //Local
    single<Realm> { ProvideRealm.realm }
    single<DoorsDataSource> { DoorsDataSourceImpl(get()) }
    single<RoomDataSource> { RoomDataSourceImpl(get()) }
    single<CamerasDataSource> { CamerasDataSourceImpl(get()) }
    //Network
    single  <HttpClient>{ NetworkService.client }
    single<NetworkEndpoints> { EndpointImpl(get()) }
    //Storage
    single<CamerasStorage> { Storage(get(), get(), get(), get()) }
    single<DoorsStorage> { Storage(get(), get(), get(), get()) }
    single<RoomsStorage> { Storage(get(), get(), get(), get()) }
    //RepositoryImpl
    single<CamerasRepository> { CamerasRepositoryImpl(get()) }
    single<DoorsRepository> { DoorsRepositoryImpl(get()) }
    single<RoomsRepository> { RoomRepositoryImpl(get()) }

    //Usecases
    factory { GetAllCamerasFromDb(get()) }
    factory { GetAllNetworkCameras(get()) }
    factory { GetAllNetworkRooms(get()) }
    factory { InsertCameraToDb(get()) }
    factory { UpdateCameraNameInDb(get()) }

    factory { GetAllDoorsInDb(get()) }
    factory { GetAllNetworkDoors(get()) }
    factory { InsertDoorsToDb(get()) }
    factory { UpdateDoorsNameInDb(get()) }

    factory { GetAllRoomFromDb(get()) }
    factory { InsertRoomToDb(get()) }


    // View Model
    viewModel {
        MainViewModel(
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
        )
    }

}