package com.example.testroom.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(BPM::class)], version = 1)
abstract class MicrolifeDatabase() : RoomDatabase() {

    companion object {
        private var instance: MicrolifeDatabase? = null
        private var DB_NAME = "microlife.db"

        fun getInstance(context: Context): MicrolifeDatabase {
            return instance ?: Room.databaseBuilder(context, MicrolifeDatabase::class.java, DB_NAME)
//                .fallbackToDestructiveMigration()
                .build().also { instance = it }
        }
    }

    abstract fun getRoomDao(): BPMDao
}