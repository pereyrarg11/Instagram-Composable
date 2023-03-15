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
import com.pereyrarg11.instagramcomposable.login.ui.LoginScreen
import com.pereyrarg11.instagramcomposable.login.ui.LoginViewModel
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
                    LoginScreen(loginViewModel = LoginViewModel())
                    /*val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.ScreenOne.route
                    ) {
                        composable(Routes.ScreenOne.route) { FirstScreenLayout(navigationController) }
                        composable(Routes.ScreenTwo.route) { SecondScreenLayout(navigationController) }
                        composable(Routes.ScreenThree.route) {
                            ThirdScreenLayout(
                                navigationController
                            )
                        }
                        composable(Routes.ScreenFour.route,
                            arguments = listOf(
                                navArgument("number") { type = NavType.IntType }
                            )
                        ) { backStackEntry ->
                            FourthScreenLayout(
                                navigationController = navigationController,
                                luckyNumber = backStackEntry.arguments?.getInt("number") ?: 0
                            )
                        }
                        composable(Routes.ScreenFive.route,
                            arguments = listOf(
                                navArgument("name") {
                                    // arguments are String type by default!
                                    defaultValue = "John Doe"
                                }
                            )
                        ) { backStackEntry ->
                            FifthScreenLayout(
                                navigationController = navigationController,
                                name = backStackEntry.arguments?.getString("name")
                            )
                        }
                    }*/
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