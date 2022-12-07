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
import com.example.testroom.BT.BtTestActivity
import com.example.testroom.Room.entity.Bt

@Composable
fun BTCardView(
    context: Context,
    h: Int,
    title: String,
    color: Color,
    intentActivity: Activity = BtTestActivity(),
    bt: Bt
) {
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
                fontSize = 22.sp
            )
            Text(
                text =
                if(bt.date == "") {
                    ""
                } else {"${bt.date}"},
                //color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(5.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "${bt.bodyTemp}",
                        color = Color.White,
                        fontSize = 42.sp
                    )
                    Text(
                        text = "°C",
                        color = Color.White,
                        fontSize = 15.sp,
                    )
                }
            }
        }
    }
}