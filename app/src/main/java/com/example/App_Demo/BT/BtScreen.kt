package com.example.App_Demo.BT

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.App_Demo.Global
import com.example.App_Demo.R
import com.example.App_Demo.Room.entity.Bt

@SuppressLint("UnrememberedMutableState")
@Composable
fun BTScreen(model: BtViewModel) {
    //填入資料庫
    var t= ""
    val isConnected by mutableStateOf(model.isConnected)
    if(isConnected) {
        t = Global.thermoProtocol!!.targetDeviceNames.toString()
    }

    //顯示介面
    val allBts by model.liveData.observeAsState(listOf())
    val list = allBts

    val connectState by mutableStateOf(model.connectState)

    Scaffold(
        topBar = { BtTopBar(t) },
        modifier = Modifier.background(Color(240, 240,240))
    ) {
        Column() {
            Text(
                text = " $connectState ",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(10.dp),
                fontSize = 20.sp,
            )

            LazyColumn() {
                items(list) { bt ->
                    BtCard(
                        title = "Body Temperature",
                        bt = bt,
                    )
                }
            }
        }
    }
}

@Composable
fun BtCard(
    title: String,
    bt: Bt,
    isClickable: Boolean = false
) {
    val context = LocalContext.current

    Card(
        modifier =
        if(isClickable) {
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable { context.startActivity(Intent(context, BtTestActivity::class.java)) }
        } else {
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        },
        backgroundColor = Color(240,240,240)
    ) {
        Row(modifier = Modifier
            .padding(10.dp)
            .background(Color(202, 225, 255))) {
            Column(modifier = Modifier.padding(8.dp,8.dp,0.dp,10.dp)) {
                Text(
                    text = title, fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "${bt.id}:  ${bt.bodyTemp}°C",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Normal", fontSize = 20.sp,
                    modifier = Modifier.padding(20.dp))
            }

            Spacer(modifier = Modifier.weight(2f))

            Column(modifier = Modifier.padding(8.dp)) {

                val d = bt.date.split(", ")
                Text(
                    //text = "${d[0]}\n${d[1]}",
                    text = bt.date,
                    fontSize = 15.sp)

                Spacer(modifier = Modifier.height(10.dp))

                Box(modifier = Modifier.padding(top = 5.dp, end = 20.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.bt),
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
fun BtTopBar(t: String) {
    TopAppBar(
        backgroundColor = Color.White) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Bt Screen",
                fontSize = 20.sp,)
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = { Global.thermoProtocol!!.disconnect() }) {
                Text(text = "disconnect")
            }
        }
    }
}
