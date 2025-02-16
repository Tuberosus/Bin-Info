package ru.me.bin_info.domain.api

import kotlinx.coroutines.flow.Flow
import ru.me.bin_info.domain.models.HistoryItem

interface HistoryRepository {
    suspend fun getHistory(): Flow<List<HistoryItem>>
}