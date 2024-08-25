package com.example.everdalestat.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface PlayerResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(playerResult: PlayerResult)


    @Delete
    suspend fun delete(playerResult: PlayerResult)

    @Query("SELECT * FROM player_result_table WHERE playerResultId = :playerResultId")
    fun getPlayerResById(playerResultId: String): Flow<List<PlayerResult>>

    @Update
    suspend fun editPlayerResult(playerResult: PlayerResult)
}