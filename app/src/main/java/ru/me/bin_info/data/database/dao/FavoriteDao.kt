package ru.me.bin_info.data.database.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.me.bin_info.data.database.entities.FavoriteEntity

interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(item: FavoriteEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getFavorite(): Flow<List<FavoriteEntity>>

    companion object {
        const val TABLE_NAME = "favorite"
    }
}