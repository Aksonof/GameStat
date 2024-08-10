package com.example.everdalestat.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "game_table")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val value1: String,
    val value2: String,
    val value3: String,
    val value4: String,
    val value5: String,
    val value6: String,
    val value7: String,
    val value8: String,
    val name: String
) : Parcelable
