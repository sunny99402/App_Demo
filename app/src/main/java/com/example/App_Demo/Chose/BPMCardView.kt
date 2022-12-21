package com.example.App_Demo.Chose

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.App_Demo.BPM.BPMTestActivity
import com.example.App_Demo.Room.entity.BPM

@Composable
fun BPMCardView(
    context: Context,
    h: Int,
    title: String,
    color: Color,
    intentActivity: Activity = BPMTestActivity(),
    bpm: BPM
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(h.dp)
            .clickable { context.startActivity(Intent(context, intentActivity::class.java)) },
        backgroundColor = color,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = " $title ",
                color = Color.White,
                fontSize = 22.sp
            )
            Text(
                text = bpm.date,
                //color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(5.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)) {
                Text(
                    text = "SYS",
                    color = Color.White,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(top = 15.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "${bpm.sys}",
                        color = Color.White,
                        fontSize = 42.sp
                    )
                    Text(
                        text = "mmHg",
                        color = Color.White,
                        fontSize = 15.sp,
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                Text(
                    text = "DIA",
                    color = Color.White,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(top = 15.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "${bpm.dia}",
                        color = Color.White,
                        fontSize = 42.sp
                    )
                    Text(
                        text = "mmHg",
                        color = Color.White,
                        fontSize = 15.sp,
                    )
                }
            }
        }
    }
}