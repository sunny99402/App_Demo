package com.example.testroom.Room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testroom.Room.entity.Bt.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class Bt {

    companion object {
        const val TABLE_NAME = "bt_entity"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Int = 0

    @ColumnInfo(name = "USER_NUMBER")
    var userNumber: String = ""

    @ColumnInfo(name = "TEMPERATURE")
    var temperature: Int = 0

    @ColumnInfo(name = "DATE")
    var date: String = ""

    @ColumnInfo(name = "AM__PM")
    var timePeriod: String? = ""
}