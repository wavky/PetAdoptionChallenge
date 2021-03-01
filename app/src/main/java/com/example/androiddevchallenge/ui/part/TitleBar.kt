package com.example.androiddevchallenge.ui.part

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleBar(title: String) {
    Surface(
        Modifier
            .height(56.dp)
            .fillMaxWidth(1f),
        elevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = title, fontSize = 24.sp)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Surface(modifier = Modifier.height(200.dp), color = Color.White) {
        Box() {
            TitleBar(title = "Cats")
        }
    }
}