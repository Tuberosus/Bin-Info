package ru.me.bin_info.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.me.bin_info.data.database.dao.FavoriteDao

@Entity(tableName = FavoriteDao.TABLE_NAME)
data class FavoriteEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val bin: String,
    val bankName: String,
    val country: String,
    val addTime: Long
)