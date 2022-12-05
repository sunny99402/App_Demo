package com.example.testroom

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testroom.BPM.BPMTestActivity
import com.example.testroom.BPM.BPMViewModel
import com.example.testroom.BPM.TopBar
import com.example.testroom.Chose.BPMCardView
import com.example.testroom.Chose.PulseCardView
import com.example.testroom.Room.BPM

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun ChoseScreen(model: BPMViewModel) {
    val context = LocalContext.current

    //顯示介面
    val allBPMs by model.liveData.observeAsState(listOf())
    val list = allBPMs

    Scaffold(
        topBar = { ChoseScreenTopBar() },
        modifier = Modifier.background(Color(240, 240,240))
    ) {
        var h: Int = 300  //欄高
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
                    if (list.isNotEmpty()) {
                        list[list.lastIndex]
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
                        if (list.isNotEmpty()) {
                            list[list.lastIndex]
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
                CardView(
                    context = context,
                    h = h,
                    title = "Body Fat",
                    color = Color(255, 165, 0),
                )
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
                fontSize = 20.sp)

            Text(content)

            /*
            if (content != null) {
                Text(
                    text = content,
                    color = Color.White
                )
            }
             */
        }
    }
}

@Composable
fun ChoseScreenTopBar() {
    TopAppBar(
        backgroundColor = Color.White) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Chose Screen",
                fontSize = 20.sp)
        }
    }
}

@Preview
@Composable
fun Pre() {
    ChoseScreenTopBar()
}