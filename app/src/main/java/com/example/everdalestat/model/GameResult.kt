package com.example.everdalestat.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "gameResult")
data class GameResult(
    @PrimaryKey(autoGenerate = true)
    val cardPoints: Int,
    val coinPoints: Int,
    val discoverPoints: Int,
    val travelPoints: Int,
    val purpleCardPoints: Int,
    val sum: Int
)
