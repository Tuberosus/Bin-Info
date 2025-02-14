package ru.me.bin_info.data.network

import ru.me.bin_info.data.dto.Response

interface NetworkClient {
    suspend fun doRequest(dto: Any): Response
}