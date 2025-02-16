package ru.me.bin_info.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import ru.me.bin_info.data.dto.Response
import ru.me.bin_info.data.dto.bin_info.BinInfoRequest
import ru.me.bin_info.util.HttpStatusCode

class RetrofitNetworkClient(
    private val context: Context,
    private val binlistApiService: BinlistApiService
) : NetworkClient {

    override suspend fun doRequest(dto: Any): Response {
        if (!isConnected()) return Response().apply { resultCode = HttpStatusCode.NOT_CONNECTED }

        return when (dto) {
            is BinInfoRequest -> {
                try {
                    val response = binlistApiService.getBinIfo(dto.bin)
                    response.apply { resultCode = HttpStatusCode.OK }
                } catch (e: Throwable) {
                    Log.d("MyTag", "doRequest: $e")
                    Response().apply { resultCode = HttpStatusCode.INTERNAL_SERVER_ERROR }
                }
            }

            else -> Response().apply { resultCode = HttpStatusCode.BAD_REQUEST }
        }
    }

    private fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
            }
        }
        return false
    }
}