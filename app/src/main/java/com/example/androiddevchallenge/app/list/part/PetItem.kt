package com.example.androiddevchallenge.app.list.part

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.domain.Pet
import com.example.androiddevchallenge.domain.PetRepo

@Composable
fun PetItem(pet: Pet, onClick: (pet: Pet) -> Unit = {}) {
    Surface(
        color = Color.White,
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable(true, onClick = { onClick(pet) }),
        shape = RoundedCornerShape(5)
    ) {
        Row(Modifier.fillMaxWidth(1f)) {
            Image(
                painterResource(id = pet.imageId),
                contentDescription = "photo",
                Modifier.size(96.dp),
                contentScale = ContentScale.Crop,
            )
            Column(
                Modifier
                    .padding(16.dp, 0.dp, 0.dp, 0.dp)
                    .fillMaxWidth(1f)
            ) {
                Text(text = pet.name, fontSize = 24.sp)
                Text(text = pet.age, modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp))
                Text(text = pet.gender.name, modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp))
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val pets = PetRepo.get()
    Surface(color = Color.White) {
        Column {
            PetItem(pets[0])
            PetItem(pets[1])
            PetItem(pets[2])
            PetItem(pets[3])
            PetItem(pets[4])
        }
    }
}