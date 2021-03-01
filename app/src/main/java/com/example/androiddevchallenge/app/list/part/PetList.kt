package com.example.androiddevchallenge.app.list.part

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.domain.Pet
import com.example.androiddevchallenge.domain.PetRepo

@Composable
fun PetList(pets: List<Pet>, modifier: Modifier = Modifier, onClick: (Pet) -> Unit) {
    LazyColumn(modifier = modifier) {
        items(pets) { pet ->
            PetItem(pet = pet, onClick)
        }
    }
}

@Preview
@Composable
private fun Preview() {
    PetList(pets = PetRepo.get(), onClick = {})
}

