package com.example.App_Demo.chose2

import android.graphics.Paint
import android.graphics.Path
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
import kotlin.math.round
import kotlin.math.roundToInt

@Composable
fun OpenLineChart(
    openLineChart: MutableState<Boolean>,
    chartTitle: String = "",
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
            ) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Text(chartTitle)
                }

                var bpmPoint = mutableListOf<Pair<String, Double>>()

                for(i in list_bpm) {
                    bpmPoint.add(Pair("${i.id}", i.pul.toDouble()))
                }

                LineChart(bpmPoint)
            }
        }
    }
}

@Composable
fun LineChart(
    data: List<Pair<String, Double>> = emptyList(),
    modifier: Modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
) {

    //x軸與左側的距離
    val spacing = 100f
    val graphColor = Color.Cyan
    val transparentGraphColor = remember { graphColor.copy(alpha = 0.5f) }
    //y軸
    val upperValue = remember { (data.maxOfOrNull { it.second }?.plus(5))?.roundToInt() ?: 0 }
    val lowerValue = remember { (data.minOfOrNull { it.second }?.toInt() ?: 0) }

    val density = LocalDensity.current

    val textPaint = remember(density) {
        Paint().apply {
            //color = android.graphics.Color.WHITE
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Canvas(modifier = modifier) {
        //x軸每項的間距
        val spacePerHour = (size.width - spacing) / data.size
        (data.indices).forEach { i ->
            val hour = data[i].first
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    hour.toString(),
                    spacing + i * spacePerHour,
                    size.height,
                    textPaint
                )
            }
        }

        val priceStep = (upperValue - lowerValue) / 5f
        (0..4).forEach { i ->
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    round(lowerValue + priceStep * i).toString(),
                    30f,
                    size.height - spacing - i * size.height / 5f,
                    textPaint
                )
            }
        }

        val strokePath = androidx.compose.ui.graphics.Path().apply {
            val height = size.height
            data.indices.forEach { i ->
                val info = data[i]
                val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                val x1 = spacing + i * spacePerHour
                val y1 = height - spacing - (ratio * height).toFloat()

                if (i == 0) { moveTo(x1, y1) }
                lineTo(x1, y1)
            }
        }

        drawPath(
            path = strokePath,
            color = graphColor,
            style = Stroke(
                width = 2.dp.toPx(),
                cap = StrokeCap.Round
            )
        )

    }
}