package com.example.testroom.Chose

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

@Composable
fun BTCardView(
    context: Context,
    h: Int,
    title: String,
    color: Color,
    intentActivity: Activity = BtTestActivity(),
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
                fontSize = 28.sp)
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