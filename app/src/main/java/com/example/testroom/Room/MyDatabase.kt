package com.example.testroom.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [(BPM::class)], version = 1)
abstract class MyDatabase() : RoomDatabase() {

    companion object {
        private var instance: MyDatabase? = null
        private var DB_NAME = "bpm.db"

        fun getInstance(context: Context): MyDatabase {
            return instance ?: Room.databaseBuilder(context, MyDatabase::class.java, DB_NAME)
//                .fallbackToDestructiveMigration()
                .build().also { instance = it }
        }
    }

    abstract fun getRoomDao(): BPMDao
}