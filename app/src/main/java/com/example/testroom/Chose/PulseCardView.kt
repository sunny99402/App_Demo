package com.example.testroom.Chose

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
import com.example.testroom.BPM.BPMTestActivity
import com.example.testroom.Room.BPM

@Composable
fun PulseCardView(
    context: Context,
    h: Int,
    title: String,
    color: Color,
    intentActivity: Activity = BPMTestActivity(), //刪除預設
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
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = " $title",
                color = Color.White,
                fontSize = 28.sp
            )
            Text(
                text = "${bpm.date}, ${bpm.timePeriod}",
                //color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "${bpm.pul}",
                        color = Color.White,
                        fontSize = 50.sp
                    )
                    Text(
                        text = "bpm",
                        color = Color.White,
                        fontSize = 15.sp,
                    )
                }
            }
        }
    }
}