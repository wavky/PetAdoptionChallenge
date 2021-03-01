package com.example.androiddevchallenge.app.detail.part

import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

@Composable
fun AdoptionFAB(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        text = {
            Text(text = "Adopt me")
        },
        onClick = {
            onClick()
        },
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_hand),
                contentDescription = "adoption icon"
            )
        },
        elevation = FloatingActionButtonDefaults.elevation(8.dp),
        modifier = modifier,
    )
}