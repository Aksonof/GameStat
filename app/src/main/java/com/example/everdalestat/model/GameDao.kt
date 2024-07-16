package com.example.everdalestat.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GameDao {

    @Insert
    suspend fun insert(gameResult: GameResult)

    @Query("SELECT * FROM gameResult")
    suspend fun getAllGames(): List<GameResult>

    @Delete
    suspend fun delete(gameResult: GameResult)
}