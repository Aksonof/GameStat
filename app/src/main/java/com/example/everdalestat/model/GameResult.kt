package com.example.everdalestat.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "result_table")
data class GameResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val playerResultId: Int,
    val game: String?,
    val winner: String,
    val sum: Int,
    val date: Long
)
