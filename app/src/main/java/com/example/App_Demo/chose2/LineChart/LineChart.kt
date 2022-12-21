package com.example.App_Demo.chose2

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.App_Demo.Room.entity.BPM
import com.example.App_Demo.Room.entity.Bt
import com.example.App_Demo.chose2.LineChart.PulLineChart
import com.example.App_Demo.chose2.LineChart.SysLineChart

@Composable
fun OpenLineChart(
    openLineChart: MutableState<Boolean>,
    chartTitle: MutableState<String> = remember { mutableStateOf("") },
    list_bpm: List<BPM> = emptyList(),
    list_bt: List<Bt> = emptyList()
) {
    if(openLineChart.value) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(modifier = Modifier
                .padding(15.dp)
                .height(300.dp)
                .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = chartTitle.value + " Line Chart",
                        fontSize = 15.sp
                    )
                }

                if(chartTitle.value == "Sys") {
                    val sysPoint = mutableListOf<Pair<String, Double>>()
                    val diaPoint = mutableListOf<Pair<String, Double>>()
                    for(i in list_bpm) {
                        sysPoint.add(Pair("${i.id}", i.sys.toDouble()))
                        diaPoint.add(Pair("${i.id}", i.dia.toDouble()))
                    }
                    SysLineChart(sysData = sysPoint, diaData = diaPoint)
                } else {
                    val bpmPoint = mutableListOf<Pair<String, Double>>()
                    for(i in list_bpm) {
                        bpmPoint.add(Pair("${i.id}", i.pul.toDouble()))
                    }
                    PulLineChart(pulData = bpmPoint)
                }
            }
        }
    }
}