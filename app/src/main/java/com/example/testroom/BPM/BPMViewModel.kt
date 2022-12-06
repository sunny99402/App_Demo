package com.example.testroom.BPM

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.*
import com.example.testroom.Room.MicrolifeDatabase
import com.example.testroom.Room.entity.BPM
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
            var isExisted: Boolean = false
            var bpm = BPM().apply {
                userNumber = dRecord.userNumber.toString()
                accountId = ""
                sys = i.systole
                dia = i.dia
                pul = i.hr
                date = "${i.year}/" +
                        if(
                            i.month<10) { "0${i.month}/"
                        } else {
                            "${i.month}/"
                        } +
                        if(
                            i.day<10) { "0${i.day}"
                        } else {
                            "${i.day}"
                        }
                timePeriod = if(
                    i.hour<10) { "0${i.hour}:"
                } else {
                    "${i.hour}:"
                } +
                        if(
                            i.minute<10) { "0${i.minute}"
                        } else {
                            "${i.minute}"
                        }
                afib = i.AFIb
                pad = 0
                mam = i.MAM
                cuffokr = i.cuffokr
                photoPath = ""
                note = ""
                recordingPath = ""
                recordTime = ""
            }
            for(j in liveData.value!!) {
                if(bpm.date == j.date && bpm.timePeriod == j.timePeriod) {
                    isExisted = true
                }
            }
            GlobalScope.launch {
                if(!isExisted) {
                    bpmDao.insert(bpm)
                }
            }
        }
    }
}