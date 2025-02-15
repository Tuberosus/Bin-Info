package ru.me.bin_info.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.me.bin_info.data.network.BinlistApiService
import ru.me.bin_info.data.network.NetworkClient
import ru.me.bin_info.data.network.RetrofitNetworkClient

val dataModule = module {

    single<BinlistApiService> {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinlistApiService::class.java)
    }

    single<NetworkClient> {
        RetrofitNetworkClient(androidContext(), get())
    }
}