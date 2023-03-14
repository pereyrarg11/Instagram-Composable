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

@Composable
fun FourthScreenLayout(navigationController: NavHostController, luckyNumber: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = "Tu número de la suerte es: $luckyNumber",
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.ScreenFive.createRoute("Gabriel"))
                }
        )
    }
}