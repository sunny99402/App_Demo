package com.example.App_Demo.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.App_Demo.Room.entity.BPM
import com.example.App_Demo.Room.entity.Bt

@Dao
interface Dao {
    //BPM
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: BPM): Long

    @Insert
    fun insertAll(item: BPM)

    @Query("SELECT * FROM bpm_entity")
    fun getAllBPMs(): LiveData<List<BPM>>

    @Delete
    fun delete(item: BPM)

    @Update
    fun update(item: BPM)

    //Bt
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Bt): Long

    @Insert
    fun insertAll(item: Bt)

    @Query("SELECT * FROM bt_entity")
    fun getAllBts(): LiveData<List<Bt>>

    @Delete
    fun delete(item: Bt)

    @Update
    fun update(item: Bt)
}