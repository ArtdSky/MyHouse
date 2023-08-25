package com.example.myhouse

import android.app.Application
import com.example.myhouse.presentation.di.DependencyInjection
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyHouseApplication  : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyHouseApplication)
            modules(listOf(DependencyInjection))
        }
    }
}