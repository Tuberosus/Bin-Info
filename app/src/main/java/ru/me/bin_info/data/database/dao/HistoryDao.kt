package ru.me.bin_info.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.me.bin_info.data.database.entities.HistoryEntity

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(item: HistoryEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getHistory(): Flow<List<HistoryEntity>>

    companion object {
        const val TABLE_NAME = "favorite"
    }
}