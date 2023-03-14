package com.pereyrarg11.instagramcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pereyrarg11.instagramcomposable.navigation.FirstScreenLayout
import com.pereyrarg11.instagramcomposable.navigation.Routes
import com.pereyrarg11.instagramcomposable.navigation.SecondScreenLayout
import com.pereyrarg11.instagramcomposable.navigation.ThirdScreenLayout
import com.pereyrarg11.instagramcomposable.recyclerview.SuperheroGrid
import com.pereyrarg11.instagramcomposable.ui.theme.InstagramComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = Routes.ScreenOne.route) {
                        composable(Routes.ScreenOne.route) { FirstScreenLayout(navigationController) }
                        composable(Routes.ScreenTwo.route) { SecondScreenLayout(navigationController) }
                        composable(Routes.ScreenThree.route) { ThirdScreenLayout(navigationController) }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InstagramComposableTheme {
        SuperheroGrid()
    }
}