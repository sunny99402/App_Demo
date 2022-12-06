package com.example.testroom.BT

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.testroom.Room.MicrolifeDatabase
import com.example.testroom.Room.entity.BPM
import com.example.testroom.Room.entity.Bt
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BtViewModel(application: Application) : AndroidViewModel(application) {
    //database
    private val database: MicrolifeDatabase = MicrolifeDatabase.getInstance(application)
    private val btDao = database.getRoomDao()
    val liveData = database.getRoomDao().getAllBts()

    var connectState by mutableStateOf("")

    @JvmName("setConnectState1")
    fun setConnectState(s: String) {
        this.connectState = s
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun insertDatabase(bt: Bt) {
        GlobalScope.launch {
            btDao.insert(bt)
        }
    }
}