package com.example.testroom.BPM

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.example.testroom.Room.MicrolifeDatabase
import com.example.testroom.Room.BPM
import com.ideabus.model.data.DRecord
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BPMViewModel(application: Application) : AndroidViewModel(application) {
    //database
    private val database: MicrolifeDatabase = MicrolifeDatabase.getInstance(application)
    private val bpmDao = database.getRoomDao()
    val liveData = database.getRoomDao().getAllBPMs()

    var isConnected by mutableStateOf(false)
    var connectState by mutableStateOf("")
    var dRecord by mutableStateOf(DRecord())
    var lastBPM by mutableStateOf(BPM())

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
        var isExisted: Boolean = false
            for(i in dRecord.MData) {
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
                    isExisted = false
                } else {
                    for(j in liveData.value!!) {
                        if(bpm.date == j.date && bpm.timePeriod ==j.timePeriod) {
                            isExisted = true
                            break
                        }
                    }
                }
                GlobalScope.launch {
                    if(!isExisted) {
                        bpmDao.insert(bpm)
                        setLastBPM(bpm)
                    }
                }
        }
    }

    @JvmName("setLastBPM1")
    private fun setLastBPM(bpm: BPM) {
        this.lastBPM = bpm
    }

}