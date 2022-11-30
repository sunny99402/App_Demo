package com.example.testroom.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BPMDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: BPM): Long

    @Insert
    fun insertAll(item: BPM)

    @Query("SELECT * FROM bpm_entity")
    fun getAllBPMs(): LiveData<List<BPM>>

    @Query("SELECT * FROM bpm_entity WHERE _id=:id")
    suspend fun getBPMById(id: Long): BPM?

    @Delete
    fun delete(item: BPM)

    @Update
    fun update(item: BPM)
}