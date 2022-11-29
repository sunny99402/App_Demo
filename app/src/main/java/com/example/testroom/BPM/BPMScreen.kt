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

    Scaffold(
        topBar = { TopBar() }
    ) {

    }
}

@Composable
fun CardView(
    title: String,
    bpm: RoomEntity,
    image: Painter,
    viewModel: BPMViewModel
) {
    var openDetailDialog = remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                openDetailDialog.value = true
            }
            .padding(5.dp),
        backgroundColor = Color(240, 240, 240)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(Color(173, 208, 233))
        ) {
            Column(modifier = Modifier.padding(8.dp, 8.dp, 0.dp, 10.dp)) {
                Text(
                    text = title, fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "${bpm.userNumber}:    ${bpm.sys}/${bpm.dia}    ${bpm.pul}",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Normal", fontSize = 20.sp,
                    modifier = Modifier.padding(20.dp)
                )
            }

            Spacer(modifier = Modifier.weight(2f))

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = bpm.date,
                    fontSize = 15.sp
                )

                Text(
                    text = bpm.timePeriod.toString(),
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(modifier = Modifier.padding(top = 5.dp, end = 20.dp)) {
                    Image(
                        painter = image,
                        contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(85.dp)
                    )
                }
            }
        }
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
