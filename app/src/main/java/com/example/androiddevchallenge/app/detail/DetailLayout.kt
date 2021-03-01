package com.example.androiddevchallenge.app.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.domain.Pet
import com.example.androiddevchallenge.domain.PetRepo

@Composable
fun DetailLayout(pet: Pet) {
    Column(Modifier.padding(8.dp)) {
        Column(
            Modifier.fillMaxWidth(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(heightDp = 16)
            Surface(shape = RoundedCornerShape(45), elevation = 8.dp) {
                Image(
                    painter = painterResource(id = pet.imageId),
                    contentDescription = "photo",
                    Modifier.size(128.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        TextDetail(pet = pet)
    }
}

@Composable
private fun Spacer(heightDp: Int) {
    Spacer(
        modifier = Modifier
            .height(heightDp.dp)
            .fillMaxWidth(1f)
    )
}

@Composable
private fun TextDetail(pet: Pet) {
    Column(Modifier.padding(32.dp, 16.dp)) {
        Subtitle(text = "Age")
        Message(text = pet.age)
        Spacer(heightDp = 8)
        Subtitle(text = "Gender")
        Message(text = pet.gender.name)
        Spacer(heightDp = 8)
        Subtitle(text = "Nationality")
        Message(text = pet.nationality)
        Spacer(heightDp = 8)
        Subtitle(text = "Favorite food")
        Message(text = pet.favoriteFood)
        Spacer(heightDp = 8)
        Subtitle(text = "Message")
        Message(text = pet.message)
    }
}

@Composable
private fun Subtitle(text: String) {
    Text(text = text, fontSize = 24.sp)
}

@Composable
private fun Message(text: String) {
    Text(text = text, fontSize = 16.sp, modifier = Modifier.padding(24.dp, 12.dp))
}

@Preview("Light Theme", widthDp = 360)
@Composable
private fun Preview() {
    Surface(color = MaterialTheme.colors.background) {
        DetailLayout(PetRepo.get()[0])
    }
}