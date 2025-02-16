package ru.me.bin_info.domain.impl

import kotlinx.coroutines.flow.Flow
import ru.me.bin_info.domain.api.GetHistoryUseCase
import ru.me.bin_info.domain.api.HistoryRepository
import ru.me.bin_info.domain.models.HistoryItem

class GetHistoryUseCaseImpl(
    private val historyRepository: HistoryRepository
) : GetHistoryUseCase{

    override suspend fun get(): Flow<List<HistoryItem>> {
        return historyRepository.getHistory()
    }
}