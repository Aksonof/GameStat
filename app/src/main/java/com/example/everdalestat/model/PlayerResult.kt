package com.example.everdalestat.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "player_result_table")
data class PlayerResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val playerResultId: String,
    val value1: Int,
    val value2: Int,
    val value3: Int,
    val value4: Int,
    val value5: Int,
    val value6: Int,
    val value7: Int,
    val value8: Int,
    val name: String
) : Parcelable