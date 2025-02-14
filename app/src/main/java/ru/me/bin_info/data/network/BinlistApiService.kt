package ru.me.bin_info.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import ru.me.bin_info.data.dto.bin_info.BinInfoResponse

interface BinlistApiService {
    @GET("/{bin}")
    suspend fun getBinIfo(@Path("bin") bin: String): BinInfoResponse
}