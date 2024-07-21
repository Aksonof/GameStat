package com.example.everdalestat.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "game_table")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val value1: String,
    val value2: String,
    val value3: String,
    val value4: String,
    val value5: String,
    val value6: String,
    val value7: String,
    val value8: String,
    val value9: String,
    val value10: String,
    val name: String
)