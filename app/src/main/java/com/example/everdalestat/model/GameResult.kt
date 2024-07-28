package com.example.everdalestat.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "result_table")
data class GameResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val game: String?,
    val nickName: String,
    val value1: Int,
    val value2: Int,
    val value3: Int,
    val value4: Int,
    val value5: Int,
    val value6: Int,
    val value7: Int,
    val value8: Int,
    val value9: Int,
    val value10: Int,
    val sum: Int
)
