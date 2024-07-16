package com.example.everdalestat.model

class GameRepository(private val gameDao: GameDao) {

    suspend fun insert(gameResult: GameResult) {
        gameDao.insert(gameResult)
    }

    suspend fun getAllGames(): List<GameResult> {
        return gameDao.getAllGames()
    }

    suspend fun delete(gameResult: GameResult) {
        gameDao.delete(gameResult)
    }
}