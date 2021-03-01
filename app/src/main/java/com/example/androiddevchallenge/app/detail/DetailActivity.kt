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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.app.detail.part.AdoptionFAB
import com.example.androiddevchallenge.domain.Pet
import com.example.androiddevchallenge.domain.PetRepo
import com.example.androiddevchallenge.ui.part.TitleBar
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val INTENT_EXTRA_PET = "PET"

        fun startActivity(activity: AppCompatActivity, pet: Pet) {
            activity.startActivity(
                Intent(activity, DetailActivity::class.java).apply {
                    putExtra(INTENT_EXTRA_PET, pet)
                }
            )
        }
    }

    private val pet: Pet?
        get() = intent.getParcelableExtra(INTENT_EXTRA_PET)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                pet?.let { pet ->
                    Surface(color = MaterialTheme.colors.background) {
                        Column {
                            TitleBar(title = pet.name)
                            Box {
                                DetailLayout(pet = pet)
                                AdoptionFAB(
                                    modifier = Modifier
                                        .align(Alignment.BottomEnd)
                                        .padding(16.dp),
                                    onClick = {
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360)
@Composable
private fun Preview() {
    val pet = PetRepo.get()[0]
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                TitleBar(title = pet.name)
                Box {
                    DetailLayout(pet = pet)
                    AdoptionFAB(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(16.dp),
                        onClick = {}
                    )
                }
            }
        }
    }
}
