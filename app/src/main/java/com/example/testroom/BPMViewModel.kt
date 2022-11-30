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
}