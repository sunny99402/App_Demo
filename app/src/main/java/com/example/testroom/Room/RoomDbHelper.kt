package com.example.testroom.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(RoomEntity::class)], version = 1)
abstract class RoomDbHelper() : RoomDatabase() {

    companion object {
        @Volatile private var instance: RoomDbHelper? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            RoomDbHelper::class.java, "bpm.db").build()
    }

    abstract fun getRoomDao(): RoomDao
}