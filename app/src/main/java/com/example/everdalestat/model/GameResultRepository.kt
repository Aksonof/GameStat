package com.example.everdalestat.model

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class GameResultRepository(private val gameResultDao: GameResultDao) {


    val allGameResults: Flow<List<GameResult>> = gameResultDao.getAllGames()

    @WorkerThread
    suspend fun insert(gameResult: GameResult) {
        gameResultDao.insert(gameResult)
    }

    suspend fun delete(gameResult: GameResult) {
        gameResultDao.delete(gameResult)
    }
}