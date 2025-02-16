package ru.me.bin_info.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.me.bin_info.data.database.dao.HistoryDao
import ru.me.bin_info.data.database.entities.HistoryEntity

@Database(version = 1, entities = [HistoryEntity::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}