package com.example.App_Demo.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.App_Demo.Room.entity.BPM
import com.example.App_Demo.Room.entity.Bt

@Database(
    entities = [(BPM::class), (Bt::class)],
    version = 1,
    exportSchema = false
)
abstract class MicrolifeDatabase() : RoomDatabase() {

    companion object {
        private var instance: MicrolifeDatabase? = null
        private var DB_NAME = "microlife.db"

        fun getInstance(context: Context): MicrolifeDatabase {
            return instance ?: Room.databaseBuilder(context, MicrolifeDatabase::class.java, DB_NAME)
//              .fallbackToDestructiveMigration()
                .build().also { instance = it }
        }
    }
    abstract fun getRoomDao(): Dao
}