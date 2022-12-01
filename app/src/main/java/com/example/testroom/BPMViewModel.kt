package com.example.testroom

import android.app.Application
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.*
import com.example.testroom.Room.MyDatabase
import com.example.testroom.Room.BPM
import com.example.testroom.Room.BPMDao
import com.ideabus.model.data.DRecord
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BPMViewModel(application: Application) : AndroidViewModel(application) {
    private val _logListData = MutableLiveData<List<String>>(emptyList())
    val logListData: LiveData<List<String>>
        get() = _logListData

    private val _bpmListData = MutableLiveData<List<BPM>>(emptyList())
    val bpmListData: LiveData<List<BPM>>
        get() = _bpmListData

    //database
    private val database: MyDatabase = MyDatabase.getInstance(application)
    private val bpmDao = database.getRoomDao()
    val liveData = database.getRoomDao().getAllBPMs()

    var isConnected by mutableStateOf(false)
    var connectState by mutableStateOf("")
    var dRecord by mutableStateOf(DRecord())

    fun addLogData(param: String) {
        _logListData.value = _logListData.value?.let { it + listOf(param) }
    }

    fun setIsConnect(b: Boolean) {
        this.isConnected = b
    }

    @JvmName("setConnectState1")
    fun setConnectState(s: String) {
        this.connectState = s
    }

    @JvmName("setDRecord1")
    fun setDRecord(dRecord: DRecord) {
        this.dRecord = dRecord
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun insertDatabase() {
        for(i in dRecord.MData) {
            GlobalScope.launch {
                var bpm = BPM().apply {
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
                }
                if(liveData.value?.isEmpty() == true) {
                    bpmDao.insert(bpm)
                }
            }
        }
    }
}