package com.example.testroom.BT

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.testroom.Room.MicrolifeDatabase
import com.example.testroom.Room.entity.BPM
import com.example.testroom.Room.entity.Bt
import com.ideabus.model.data.ThermoMeasureData
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BtViewModel(application: Application) : AndroidViewModel(application) {
    //database
    private val database: MicrolifeDatabase = MicrolifeDatabase.getInstance(application)
    private val btDao = database.getRoomDao()
    val liveData = database.getRoomDao().getAllBts()

    var isConnected by mutableStateOf(false)
    var connectState by mutableStateOf("")

    fun setIsConnect(b: Boolean) {
        this.isConnected = b
    }

    @JvmName("setConnectState1")
    fun setConnectState(s: String) {
        this.connectState = s
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun insertDatabase(data: ThermoMeasureData) {
        var isExisted: Boolean = false
        val bt = Bt().apply {
            bodyTemp = data.measureTemperature
            roomTemp = data.ambientTemperature
            date = "20${data.year}-" +
                    if(data.month<10) { "0${data.month}-" } else { "${data.month}-" } +
                    if(data.day<10) { "0${data.day}, " } else { "${data.day}, " } +
                    if(data.hour<10) { "0${data.hour}:" } else { "${data.hour}:" } +
                    if(data.minute<10) { "0${data.minute}" } else { "${data.minute}" }
        }
        for(i in liveData.value!!) {
            if(bt.date == i.date) {
                isExisted = true
            }
        }
        if(!isExisted) {
            GlobalScope.launch {
                btDao.insert(bt)
            }
        }
    }
}