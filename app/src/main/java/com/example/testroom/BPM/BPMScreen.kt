package com.example.testroom.BPM

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testroom.BPMViewModel
import com.example.testroom.Global
import com.example.testroom.Room.RoomEntity
import com.example.testroom.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun BPMScreen(model: BPMViewModel) {
    //create room database
    val connectState by mutableStateOf(model.isConnect)
    if(connectState) {
        Global.bpmProtocol!!.readHistorysOrCurrDataAndSyncTiming()
    }
    
    val dRecord by mutableStateOf(model.dRecord)

    Scaffold(
        topBar = { TopBar() }
    ) {
        Text(text = dRecord.MData.toString())
    }
}


@Composable
fun TopBar() {
    TopAppBar(backgroundColor = Color.White) {
        Text(text = "testRoom")
    }
}

@Preview
@Composable
fun TestPreview() {
    TopBar()
}
