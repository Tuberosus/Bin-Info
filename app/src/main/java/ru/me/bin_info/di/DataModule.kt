package ru.me.bin_info.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.me.bin_info.data.network.BinlistApiService
import ru.me.bin_info.data.network.NetworkClient
import ru.me.bin_info.data.network.RetrofitNetworkClient

val dataModule = module {

    single<BinlistApiService> {
        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinlistApiService::class.java)
    }

    single<NetworkClient> {
        RetrofitNetworkClient(androidContext(), get())
    }
}