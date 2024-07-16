package com.example.everdalestat.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GameResult::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gameDao(): GameDao
}