package com.example.App_Demo.chose2.LineChart

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round
import kotlin.math.roundToInt

@Composable
fun SysLineChart(
    sysData: List<Pair<String, Double>> = emptyList(),
    diaData: List<Pair<String, Double>> = emptyList(),
    modifier: Modifier = Modifier,
) {
    val padding = 36.dp
    val upperValue = remember { (sysData.maxOfOrNull { it.second }?.plus(7))?.roundToInt() ?: 0 }
    val lowerValue = remember { (diaData.minOfOrNull { it.second }?.toInt() ?: 0) }

    val density = LocalDensity.current
    val textPaint = remember(density) {
        Paint().apply {
            //color = android.graphics.Color.WHITE
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }

    Column(Modifier) {
        Surface(modifier) {
            Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                val paddingPx = padding.toPx()
                val strokeWidth = 1.dp.toPx()
                val chartWidth = size.width - 2 * paddingPx
                val chartHeight = size.height - 2 * paddingPx
                val xInterval = chartWidth / sysData.size

                //val spacePerHour = (size.width) / data.size
                val spacing = 15.dp.toPx()

                translate(left = paddingPx, top = paddingPx) {
                    //y軸
                    drawLine(
                        color = Color.DarkGray,
                        start = Offset(0f, 0f),
                        end = Offset(0f, 0f + chartHeight),
                        strokeWidth = strokeWidth,
                    )
                    //x軸
                    drawLine(
                        color = Color.DarkGray,
                        start = Offset(0f, chartHeight),
                        end = Offset(chartWidth, chartHeight),
                        strokeWidth = strokeWidth,
                    )

                    //y 文字
                    if(sysData.isNotEmpty()) {
                        val priceStep = (upperValue - lowerValue) / 5f
                        (0..4).forEach { i ->
                            drawContext.canvas.nativeCanvas.apply {
                                drawText(
                                    round(lowerValue + priceStep * i).toString(),
                                    -( spacing ),
                                    chartHeight - spacing - i * chartHeight / 5f,
                                    textPaint
                                )
                            }
                        }
                    }

                    //x 文字
                    val spacePerHour = (chartWidth - spacing) / sysData.size
                    (sysData.indices).forEach { i ->
                        val hour = sysData[i].first
                        drawContext.canvas.nativeCanvas.apply {
                            drawText(
                                hour.toString(),
                                spacing + i * spacePerHour,
                                chartHeight + (spacing),
                                textPaint
                            )
                        }
                    }

                    /*
                    val points = lineData.points.mapIndexed { index, dataPoint ->
                        val x = index * xInterval
                        val y = chartHeight - (chartHeight / 100 * dataPoint.yLabel)
                        Offset(x, y)
                    }
                     */

                    //sys曲線
                    val sysPath = androidx.compose.ui.graphics.Path().apply {
                        sysData.indices.forEach { i ->
                            val info = sysData[i]
                            val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                            val x1 = i * xInterval
                            val y1 = chartHeight - spacing - (ratio * chartHeight).toFloat()

                            if (i == 0) { moveTo(x1, y1) }
                            lineTo(x1, y1)
                        }
                    }
                    drawPath(
                        path = sysPath,
                        color = Color.Blue,
                        style = Stroke(
                            width = 2.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    )

                    //dia曲線
                    //曲線
                    val diaPath = androidx.compose.ui.graphics.Path().apply {
                        diaData.indices.forEach { i ->
                            val info = diaData[i]
                            val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                            val x1 = i * xInterval
                            val y1 = chartHeight - spacing - (ratio * chartHeight).toFloat()

                            if (i == 0) { moveTo(x1, y1) }
                            lineTo(x1, y1)
                        }
                    }
                    drawPath(
                        path = diaPath,
                        color = Color.Red,
                        style = Stroke(
                            width = 2.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    )
                }
            })
        }
    }
}