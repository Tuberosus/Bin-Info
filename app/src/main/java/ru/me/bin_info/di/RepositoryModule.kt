package ru.me.bin_info.di

import org.koin.dsl.module
import ru.me.bin_info.data.impl.BinInfoRepositoryImpl
import ru.me.bin_info.domain.api.BinInfoRepository

val repositoryModule = module {
    single<BinInfoRepository> {
        BinInfoRepositoryImpl(get(), get())
    }
}