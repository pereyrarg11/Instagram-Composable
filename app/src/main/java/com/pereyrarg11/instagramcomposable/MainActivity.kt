package com.pereyrarg11.instagramcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pereyrarg11.instagramcomposable.login.ui.LoginScreen
import com.pereyrarg11.instagramcomposable.login.ui.LoginViewModel
import com.pereyrarg11.instagramcomposable.navigation.*
import com.pereyrarg11.instagramcomposable.recyclerview.SuperheroGrid
import com.pereyrarg11.instagramcomposable.ui.theme.InstagramComposableTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //LoginScreen(loginViewModel)
                    val navigationController = rememberNavController()
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