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
package com.example.androiddevchallenge.app.list

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.androiddevchallenge.app.detail.DetailActivity
import com.example.androiddevchallenge.app.list.part.PetList
import com.example.androiddevchallenge.domain.PetRepo
import com.example.androiddevchallenge.ui.part.TitleBar
import com.example.androiddevchallenge.ui.theme.MyTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Column {
                        TitleBar(title = "Cats")
                        PetList(
                            pets = PetRepo.get(),
                            modifier = Modifier.fillMaxHeight(1f),
                            onClick = { pet ->
                                lifecycleScope.launch {
                                    delay(500)
                                    DetailActivity.startActivity(this@ListActivity, pet)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 340)
@Composable
private fun Preview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            Column {
                TitleBar(title = "Cats")
                PetList(pets = PetRepo.get(), Modifier.fillMaxHeight(1f), onClick = {})
            }
        }
    }
}
