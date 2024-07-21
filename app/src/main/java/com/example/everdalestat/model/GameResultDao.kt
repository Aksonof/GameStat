package com.example.everdalestat.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GameResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(gameResult: GameResult)

    @Query("SELECT * FROM result_table")
    fun getAllGames(): Flow<List<GameResult>>

    @Delete
    suspend fun delete(gameResult: GameResult)

}