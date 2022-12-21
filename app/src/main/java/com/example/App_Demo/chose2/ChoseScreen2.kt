package com.example.App_Demo.chose2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.App_Demo.BPM.BPMCard
import com.example.App_Demo.BPM.BPMViewModel
import com.example.App_Demo.BT.BtCard
import com.example.App_Demo.BT.BtViewModel
import com.example.App_Demo.ChoseScreenTopBar
import com.example.App_Demo.Room.entity.BPM
import com.example.App_Demo.Room.entity.Bt

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

    //是否顯示折線圖
    var openLineChart = remember { mutableStateOf(false) }

    Scaffold(
        topBar = { ChoseScreenTopBar(openLineChart) },
        modifier = Modifier.background(Color(240, 240,240)),
    ) {
        Box() {
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
            OpenLineChart(
                openLineChart = openLineChart,
                list_bpm = list_bpm
            )
        }
    }
}