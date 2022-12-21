package com.example.App_Demo.BPM

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.App_Demo.Global
import com.example.App_Demo.Room.entity.BPM
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.App_Demo.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun BPMScreen(model: BPMViewModel) {
    //填入資料庫
    val isConnected by mutableStateOf(model.isConnected)
    if(isConnected) {
        Global.bpmProtocol!!.readHistorysOrCurrDataAndSyncTiming()
    }

    //顯示介面
    val allBPMs by model.liveData.observeAsState(listOf())
    val list = allBPMs

    val connectState by mutableStateOf(model.connectState)

    Scaffold(
        topBar = { BPMTopBar() },
        modifier = Modifier.background(Color(240, 240,240))
    ) {
        Column()
        {
            Text(
                text = " $connectState ",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(10.dp),
                fontSize = 20.sp,
            )
            LazyColumn() {
                items(list) { bpm ->
                    BPMCard(
                        title = "Blood Pressure",
                        bpm = bpm,
                    )
                }
            }
        }
    }
}

@Composable
fun BPMTopBar() {
    TopAppBar(
        backgroundColor = Color.White) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "BPM Screen",
                fontSize = 20.sp,)
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = { Global.bpmProtocol!!.disconnect() }) {
                Text(text = "disconnect")
            }
        }

    }
}

@Preview
@Composable
fun Pre() {
    BPMTopBar()
}
