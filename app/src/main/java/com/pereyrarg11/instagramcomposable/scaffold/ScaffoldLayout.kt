package com.pereyrarg11.instagramcomposable.scaffold

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ScaffoldScreen() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        // https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#Scaffold(androidx.compose.ui.Modifier,androidx.compose.material.ScaffoldState,kotlin.Function0,kotlin.Function0,kotlin.Function1,kotlin.Function0,androidx.compose.material.FabPosition,kotlin.Boolean,kotlin.Function1,kotlin.Boolean,androidx.compose.ui.graphics.Shape,androidx.compose.ui.unit.Dp,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,kotlin.Function1)
        topBar = {
            TopAppBarLayout(onClickIcon = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Haz pulsado $it")
                }
            }, onClickDrawer = {
                coroutineScope.launch { scaffoldState.drawerState.open() }
            })
        },
        scaffoldState = scaffoldState,
        bottomBar = { BottomNavLayout() },
        floatingActionButton = { FabLayout() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerContent = {
            DrawerLayout {
                coroutineScope.launch { scaffoldState.drawerState.close() }
            }
        },
        drawerGesturesEnabled = true,
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        )
    }
}

@Composable
fun TopAppBarLayout(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Top app bar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "back")
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

@Composable
fun BottomNavLayout() {
    var index by remember { mutableStateOf(0) }
    BottomNavigation(
        backgroundColor = Color.Red,
        contentColor = Color.White,
    ) {
        BottomNavigationItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Inicio")
            },
            label = { Text(text = "Inicio") }
        )

        BottomNavigationItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
            },
            label = { Text(text = "Favoritos") }
        )
    }
}

@Composable
fun FabLayout() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = Color.Cyan,
        contentColor = Color.White,
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
}

@Composable
fun DrawerLayout(onCloseDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "Primera Opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Segunda Opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Tercera Opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Cuarta Opción", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text(
            text = "Cerrar", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() },
            color = Color.Red
        )
    }
}