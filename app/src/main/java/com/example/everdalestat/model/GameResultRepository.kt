package com.example.everdalestat.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class GameResultRepository(private val gameResultDao: GameResultDao) {


    fun allGameResults(name: String): Flow<List<GameResult>> = gameResultDao.getGamesByName(name)

    @WorkerThread
    suspend fun insert(gameResult: GameResult) {
        gameResultDao.insert(gameResult)
    }

    suspend fun delete(gameResult: GameResult) {
        gameResultDao.delete(gameResult)
    }
}