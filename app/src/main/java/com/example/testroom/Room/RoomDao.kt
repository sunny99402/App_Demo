package com.example.testroom.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ideabus.model.data.CurrentAndMData

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: RoomEntity): Long

    @Insert
    fun insertAll(item: RoomEntity)

    @Query("SELECT * FROM bpm_entity")
    fun getAllBPMs(): LiveData<List<RoomEntity>>

    @Delete
    fun delete(item: RoomEntity)

    @Update
    fun update(item: RoomEntity)
}