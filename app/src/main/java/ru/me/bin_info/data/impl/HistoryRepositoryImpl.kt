package ru.me.bin_info.data.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.me.bin_info.data.database.AppDatabase
import ru.me.bin_info.data.database.entities.HistoryEntity
import ru.me.bin_info.domain.api.HistoryRepository
import ru.me.bin_info.domain.models.HistoryItem

class HistoryRepositoryImpl(
    private val db: AppDatabase
) : HistoryRepository {

    override suspend fun getHistory(): Flow<List<HistoryItem>> {
        return db.historyDao().getHistory().map {
            convertDbHistory(it)
        }
    }

    private fun convertDbHistory(entities: List<HistoryEntity>): List<HistoryItem> {
        return entities.map {
            HistoryItem(
                bin = it.bin,
                bankName = it.bankName,
                country = it.country
            )
        }
    }
}