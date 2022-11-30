package com.example.testroom

import androidx.compose.runtime.*
import androidx.core.app.ComponentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testroom.Room.RoomDao
import com.example.testroom.Room.RoomDbHelper
import com.example.testroom.Room.RoomEntity
import com.ideabus.model.data.CurrentAndMData
import com.ideabus.model.data.DRecord
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BPMViewModel: ViewModel() {
    private val _logListData = MutableLiveData<List<String>>(emptyList())
    val logListData: LiveData<List<String>>
        get() = _logListData

    private val _bpmListData = MutableLiveData<List<RoomEntity>>(emptyList())
    val bpmListData: LiveData<List<RoomEntity>>
        get() = _bpmListData


    var name by mutableStateOf("")
    var isConnect by mutableStateOf(false)
    var dRecord by mutableStateOf(DRecord())

    fun addData(param: String) {
        _logListData.value = _logListData.value?.let { it + listOf(param) }
    }

    fun deviceName(name: String) {
        this.name = name
    }

    fun setConnectState(b: Boolean) {
        this.isConnect = b
    }

    @JvmName("setDRecord1")
    fun setDRecord(dRecord: DRecord) {
        this.dRecord = dRecord
    }

    fun setDatabase(activity: ComponentActivity) {
        //room database
        val db = RoomDbHelper(activity)
        for(i in dRecord.MData) {
            GlobalScope.launch {
                db.getRoomDao().insert(RoomEntity().apply {
                    userNumber = dRecord.userNumber.toString()
                    accountId = ""
                    sys = i.systole
                    dia = i.dia
                    pul = 0
                    date = "${i.year}/${i.month}/${i.day}"
                    timePeriod = "${i.hour}:${i.minute}"
                    afib = i.AFIb
                    pad = 0
                    mam = i.MAM
                    cuffokr = i.cuffokr
                    photoPath = ""
                    note = ""
                    recordingPath = ""
                    recordTime = ""
                })
            }
        }
    }
}