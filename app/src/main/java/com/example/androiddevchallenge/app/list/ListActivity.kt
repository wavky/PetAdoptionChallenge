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
