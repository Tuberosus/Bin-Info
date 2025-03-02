package ru.me.bin_info.domain.api

import kotlinx.coroutines.flow.Flow
import ru.me.bin_info.domain.models.HistoryItem

interface GetHistoryUseCase {
    suspend fun get(): Flow<List<HistoryItem>>
}