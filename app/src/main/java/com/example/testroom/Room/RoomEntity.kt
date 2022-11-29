package com.example.testroom.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testroom.Room.RoomEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
class RoomEntity {

    companion object {
        const val TABLE_NAME = "bpm_entity"
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id") var id: Int = 0

    @ColumnInfo(name = "USER_NUMBER")
    var userNumber: String = ""

    @ColumnInfo(name = "ACCOUNT_ID")
    var accountId: String = ""

    @ColumnInfo(name = "SYS")
    var sys: Int = 0

    @ColumnInfo(name = "DIA")
    var dia: Int = 0

    @ColumnInfo(name = "PUL")
    var pul: Int = 0

    @ColumnInfo(name = "DATE")
    var date: String = ""

    @ColumnInfo(name = "AM__PM")
    var timePeriod: String? = ""

    @ColumnInfo(name = "AFIB")
    var afib: Boolean = false

    @ColumnInfo(name = "PAD")
    var pad: Int = 0

    @ColumnInfo(name = "MAN")
    var mam: Int = 0

    @ColumnInfo(name = "CUFFOKR")
    var cuffokr: Int = 0

    @ColumnInfo(name = "PHOTO_PATH")
    var photoPath: String? = ""

    @ColumnInfo(name = "NOTE")
    var note: String? = ""

    @ColumnInfo(name = "RECORDING_PATH")
    var recordingPath: String? = ""

    @ColumnInfo(name = "RECORD_TIME")
    var recordTime: String? = ""

}