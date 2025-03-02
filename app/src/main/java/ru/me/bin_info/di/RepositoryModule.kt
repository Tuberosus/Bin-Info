package ru.me.bin_info.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import ru.me.bin_info.data.impl.BinInfoRepositoryImpl
import ru.me.bin_info.data.impl.ExternalNavigatorImpl
import ru.me.bin_info.data.impl.HistoryRepositoryImpl
import ru.me.bin_info.domain.api.BinInfoRepository
import ru.me.bin_info.domain.api.ExternalNavigator
import ru.me.bin_info.domain.api.HistoryRepository

val repositoryModule = module {

    single<BinInfoRepository> {
        BinInfoRepositoryImpl(get(), get())
    }

    single<HistoryRepository> {
        HistoryRepositoryImpl(get())
    }

    single<ExternalNavigator> {
        ExternalNavigatorImpl(androidContext())
    }
}