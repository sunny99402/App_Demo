package com.example.testroom.chose2

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.testroom.BPM.BPMCard
import com.example.testroom.BPM.BPMViewModel
import com.example.testroom.BT.BtCard
import com.example.testroom.BT.BtViewModel
import com.example.testroom.ChoseScreenTopBar
import com.example.testroom.Room.entity.BPM
import com.example.testroom.Room.entity.Bt

@Composable
fun ChoseScreen2(
    bpmViewModel: BPMViewModel,
    btViewModel: BtViewModel
) {
    val context = LocalContext.current

    //顯示介面
    val allBPMs by bpmViewModel.liveData.observeAsState(listOf())
    val list_bpm = allBPMs
    val allBts by btViewModel.liveData.observeAsState(listOf())
    val list_bt = allBts

    Scaffold(
        topBar = { ChoseScreenTopBar() },
        modifier = Modifier.background(Color(240, 240,240)),
    ) {
        LazyColumn() {
            item {
                BPMCard(
                    title = "Blood Pressure",
                    bpm =
                    if (list_bpm.isNotEmpty()) {
                        list_bpm[list_bpm.lastIndex]
                    } else{
                        BPM()
                    },
                    isClickable = true
                )
            }
            item {
                BtCard(
                    title = "Body Temperature",
                    bt =
                    if (list_bt.isNotEmpty()) {
                        list_bt[list_bt.lastIndex]
                    } else{
                        Bt()
                    },
                    isClickable = true
                )
            }
        }
    }
}