package com.pereyrarg11.instagramcomposable.recyclerview

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecyclerView() {
    val names =
        listOf("Gabriel", "Miguel", "Israel", "Kenia", "Uriel", "Noelia", "Francisco", "Efrain")
    LazyColumn {
        item {
            Text(text = "Header")
        }
        items(names) {
            Text(text = "Hola, me llamo $it")
        }
        item {
            Text(text = "Footer")
        }
    }
}