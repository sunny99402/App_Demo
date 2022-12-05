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

    @Query("SELECT COUNT(*) FROM bpm_entity")
    fun getRowCount(): Int

    @Query("SELECT date FROM bpm_entity WHERE _id= :id")
    fun getDateById(id: Int): String

    @Query("SELECT AM__PM FROM bpm_entity WHERE _id= :id")
    fun getTimePeriodById(id: Int): String

    @Delete
    fun delete(item: BPM)

    @Update
    fun update(item: BPM)
}