package com.example.everdalestat.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "result_table")
data class GameResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val playerResultId: String,
    val game: String?,
    val winner: String,
    val sum: Int,
    val date: String
) : Parcelable
