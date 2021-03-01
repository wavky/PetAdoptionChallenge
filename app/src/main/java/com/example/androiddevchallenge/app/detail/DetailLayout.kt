/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.app.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
