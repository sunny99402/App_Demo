package com.example.App_Demo.chose2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.App_Demo.BPM.BPMCard
import com.example.App_Demo.BPM.BPMViewModel
import com.example.App_Demo.BT.BtCard
import com.example.App_Demo.BT.BtViewModel
import com.example.App_Demo.Room.entity.BPM
import com.example.App_Demo.Room.entity.Bt

@Composable
fun ChoseScreen2(
    bpmViewModel: BPMViewModel,
    btViewModel: BtViewModel
) {
    //顯示介面
    val allBPMs by bpmViewModel.liveData.observeAsState(listOf())
    val list_bpm = allBPMs
    val allBts by btViewModel.liveData.observeAsState(listOf())
    val list_bt = allBts

    //是否顯示折線圖
    var openLineChart = remember { mutableStateOf(false) }
    //哪種圖
    var lineChartType = remember { mutableStateOf("") }

    Scaffold(
        topBar = { ChoseScreenTopBar() },
        bottomBar = { ChoseScreenBottomBar(openLineChart = openLineChart, lineChartType = lineChartType) },
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
                list_bpm = list_bpm,
                chartTitle = lineChartType
            )
        }
    }
}

@Composable
fun ChoseScreenBottomBar(
    openLineChart: MutableState<Boolean>,
    lineChartType: MutableState<String>
) {
    BottomAppBar(
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            //horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sys & Dia Line Chart",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .clickable {
                        openLineChart.value = !openLineChart.value
                        lineChartType.value = "Sys"
                     },
                textAlign = TextAlign.Center
            )
            Text(text = "|")
            Text(
                text = "Pul Line Chart",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
                    .clickable {
                        openLineChart.value = !openLineChart.value
                        lineChartType.value = "Pul"
                    },
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ChoseScreenTopBar(
) {
    TopAppBar(
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Chose Screen",
                fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))

        }
    }
}

@Composable
@Preview
fun PreViewTop() {
    ChoseScreenTopBar()
}

@Composable
@Preview
fun PreViewBottom() {
    ChoseScreenBottomBar(
        openLineChart = remember { mutableStateOf(false) },
        lineChartType = remember { mutableStateOf("") }
    )
}