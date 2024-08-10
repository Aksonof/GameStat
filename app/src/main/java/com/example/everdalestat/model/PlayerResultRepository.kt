package com.example.everdalestat.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class PlayerResultRepository(private val playerResultDao: PlayerResultDao) {

    fun allPlayerResults(playerResultId: Int): Flow<List<PlayerResult>> =
        playerResultDao.getPlayerResById(playerResultId)

    @WorkerThread
    suspend fun insert(playerResult: PlayerResult) {
        playerResultDao.insert(playerResult)
    }

    suspend fun delete(playerResult: PlayerResult) {
        playerResultDao.delete(playerResult)
    }


}