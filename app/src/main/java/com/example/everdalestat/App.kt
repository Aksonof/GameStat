package com.example.everdalestat

import android.app.Application
import androidx.room.Room
import com.example.everdalestat.model.AppDatabase
import com.example.everdalestat.model.GameRepository

class App : Application() {

    val database by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "gameResult_database")
            .build()
    }
    val repository by lazy {
        GameRepository(database.gameDao())
    }
}