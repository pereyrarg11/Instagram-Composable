package com.pereyrarg11.instagramcomposable.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import kotlin.random.Random

@Composable
fun ThirdScreenLayout(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = "Pantalla 3",
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    val random = (1..100).random()
                    navigationController.navigate(Routes.ScreenFour.createRoute(random))
                }
        )
    }
}