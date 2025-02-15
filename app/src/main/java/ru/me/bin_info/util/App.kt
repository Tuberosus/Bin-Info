package ru.me.bin_info.util

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.me.bin_info.di.dataModule
import ru.me.bin_info.di.repositoryModule
import ru.me.bin_info.di.useCaseModule
import ru.me.bin_info.di.viewModelModel

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, repositoryModule, useCaseModule, viewModelModel)
        }
    }
}