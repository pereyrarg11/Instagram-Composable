package com.pereyrarg11.instagramcomposable.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBarLayout {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Haz pulsado $it")
                }
            }
        },
        scaffoldState = scaffoldState
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        )
    }
}

@Composable
fun TopAppBarLayout(onClickIcon: (String) -> Unit) {
    TopAppBar(
        title = { Text(text = "Top app bar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickIcon("Atrás") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("Más") }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "more")
            }
        }
    )
}