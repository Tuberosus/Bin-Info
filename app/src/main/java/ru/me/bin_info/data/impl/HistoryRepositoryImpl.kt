package ru.me.bin_info.data.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.me.bin_info.data.database.AppDatabase
import ru.me.bin_info.data.database.entities.FavoriteEntity
import ru.me.bin_info.domain.api.HistoryRepository
import ru.me.bin_info.domain.models.HistoryItem

class HistoryRepositoryImpl(
    private val db: AppDatabase
) : HistoryRepository {

    override suspend fun getHistory(): Flow<List<HistoryItem>> {
        return db.favoriteDao().getFavorite().map {
            convertDbHistory(it)
        }
    }

    private fun convertDbHistory(entities: List<FavoriteEntity>): List<HistoryItem> {
        return entities.map {
            HistoryItem(
                bin = it.bin,
                bankName = it.bankName,
                country = it.country
            )
        }
    }
}