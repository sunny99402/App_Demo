package com.example.App_Demo.chose2

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.App_Demo.Room.entity.BPM
import com.example.App_Demo.Room.entity.Bt
import com.example.App_Demo.chose2.LineChart.PulLineChart
import com.example.App_Demo.chose2.LineChart.SysLineChart
import kotlin.math.round
import kotlin.math.roundToInt

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
                    var bpmPoint = mutableListOf<Pair<String, Double>>()
                    for(i in list_bpm) {
                        bpmPoint.add(Pair("${i.id}", i.sys.toDouble()))
                    }
                    SysLineChart(bpmPoint)
                } else {
                    var bpmPoint = mutableListOf<Pair<String, Double>>()
                    for(i in list_bpm) {
                        bpmPoint.add(Pair("${i.id}", i.pul.toDouble()))
                    }
                    PulLineChart(bpmPoint)
                }
            }
        }
    }
}