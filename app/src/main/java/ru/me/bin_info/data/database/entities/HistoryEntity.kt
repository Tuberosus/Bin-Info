package ru.me.bin_info.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.me.bin_info.data.database.dao.HistoryDao

@Entity(tableName = HistoryDao.TABLE_NAME)
data class HistoryEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val bin: String,
    val bankName: String,
    val country: String,
    val addTime: Long
)