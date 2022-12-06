package com.example.testroom.BT

import android.annotation.SuppressLint
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testroom.Global
import com.example.testroom.R
import com.example.testroom.Room.entity.Bt
import kotlin.random.Random

@SuppressLint("UnrememberedMutableState")
@Composable
fun BTScreen(model: BtViewModel) {
    //顯示介面
    val allBts by model.liveData.observeAsState(listOf())
    val list = allBts

    val connectState by mutableStateOf(model.connectState)

    Scaffold(
        topBar = { BtTopBar() },
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
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally),
                onClick = {
                    model.insertDatabase(Bt().apply {
                        userNumber = "123"
                        temperature = (35..38).random()
                        date = "2022/12/06"
                        timePeriod = "13:21"
                    })
                }
            ) {
                Text(text = "insert")
            }
            LazyColumn() {
                items(list) { bt ->
                    BtCardView(
                        title = "Body Temperature",
                        bt = bt,
                        image = painterResource(id = R.drawable.bp),
                        viewModel = model
                    )
                }
            }
        }

    }
}

@Composable
fun BtCardView(
    title: String,
    bt: Bt,
    image: Painter,
    viewModel: BtViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(5.dp),
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
                    text = "${bt.id}:  ${bt.temperature}°C",
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
                Text(
                    text = bt.date,
                    fontSize = 15.sp)

                Text(
                    text = bt.timePeriod.toString(),
                    fontSize = 15.sp)

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
fun BtTopBar() {
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
