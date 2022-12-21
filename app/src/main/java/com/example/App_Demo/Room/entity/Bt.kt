package com.example.App_Demo.Room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.App_Demo.Room.entity.Bt.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class Bt {

    companion object {
        const val TABLE_NAME = "bt_entity"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Int = 0

    @ColumnInfo(name = "EVENT_ID")
    var eventId: Int = 0

    @ColumnInfo(name = "ACCOUNT_ID")
    var accountId: String = ""

    @ColumnInfo(name = "BODY_TEMP")
    var bodyTemp: Float = 0F

    @ColumnInfo(name = "ROOM_TEMP")
    var roomTemp: Float = 0F

    @ColumnInfo(name = "DATE")
    var date: String = ""

    @ColumnInfo(name = "PHOTO_PATH")
    var photoPath: String? = ""

    @ColumnInfo(name = "NOTE")
    var note: String? = ""

    @ColumnInfo(name = "RECORDING_PATH")
    var recordingPath: String? = ""

    @ColumnInfo(name = "RECORD_TIME")
    var recordTime: String? = ""
}