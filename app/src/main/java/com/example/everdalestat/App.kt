package com.example.everdalestat

import android.app.Application
import com.example.everdalestat.model.AppDatabase
import com.example.everdalestat.model.GameRepository
import com.example.everdalestat.model.GameResultRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val gameRepository by lazy { GameRepository(database.gameDao()) }
    val gameResultRepository by lazy { GameResultRepository(database.gameResultDao()) }
}