package com.example.testroom

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChoseScreen() {
    val numbers = (0..20).toList()

    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(numbers.size) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Number")
                Text(text = "  $it",)
            }
        }
    }
}