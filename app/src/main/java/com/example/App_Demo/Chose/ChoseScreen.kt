package com.example.App_Demo

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.App_Demo.BPM.BPMTestActivity
import com.example.App_Demo.BPM.BPMViewModel
import com.example.App_Demo.BT.BtViewModel
import com.example.App_Demo.Chose.BPMCardView
import com.example.App_Demo.Chose.BTCardView
import com.example.App_Demo.Chose.PulseCardView
import com.example.App_Demo.Room.entity.BPM
import com.example.App_Demo.Room.entity.Bt

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun ChoseScreen(
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
        var h: Int = 330  //欄高
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            item() {
                BPMCardView(
                    context = context,
                    h = h,
                    title = "Blood Pressure",
                    color = Color(135, 206, 255),
                    intentActivity = BPMTestActivity(),
                    bpm =
                    if (list_bpm.isNotEmpty()) {
                        list_bpm[list_bpm.lastIndex]
                    } else{
                        BPM()
                    }
                )
            }
            item() {
                Column() {
                    PulseCardView(
                        context = context,
                        h = h/2-2,
                        title = "Pulse",
                        color = Color(154, 205, 50),
                        bpm =
                        if (list_bpm.isNotEmpty()) {
                            list_bpm[list_bpm.lastIndex]
                        } else{
                            BPM()
                        }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    CardView(
                        context = context,
                        h = h/2-2,
                        title = "Visceral Fat",
                        color = Color(171, 130, 255),
                    )
                }
            }
            item() {
                Column() {
                    CardView(
                        context = context,
                        h = h/2-2,
                        title = "Body Fat",
                        color = Color(255, 165, 0),
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    BTCardView(
                        context = context,
                        h = h/2-2,
                        title = "Body Temperature",
                        color = Color(255,181,197),
                        bt =
                        if (list_bt.isNotEmpty()) {
                            list_bt[list_bt.lastIndex]
                        } else{
                            Bt()
                        }
                    )
                }
            }
            item() {
                CardView(
                    context = context,
                    h = h,
                    title = "Skeletal Muscle",
                    color = Color(135, 206, 255),
                )
            }
        }
    }
}

@Composable
fun CardView(
    context: Context,
    h: Int,
    title: String,
    color: Color,
    intentActivity: Activity = BPMTestActivity(), //刪除預設
    content: String = "" //刪除預設
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(h.dp)
            .clickable { context.startActivity(Intent(context, intentActivity::class.java)) },
        backgroundColor = color,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = " $title",
                color = Color.White,
                fontSize = 22.sp)
        }
    }
}

@Composable
fun ChoseScreenTopBar(
    openLineChart: MutableState<Boolean>,
) {
    TopAppBar(
        backgroundColor = Color.White) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Chose Screen",
                fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = { openLineChart.value = !openLineChart.value }) {
                Text(text = "Line Chart")
            }
        }
    }
}