package ru.me.bin_info.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.me.bin_info.data.database.dao.FavoriteDao
import ru.me.bin_info.data.database.entities.FavoriteEntity

@Database(version = 1, entities = [FavoriteEntity::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
}