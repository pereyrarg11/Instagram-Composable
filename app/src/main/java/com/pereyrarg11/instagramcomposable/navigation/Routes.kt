package com.pereyrarg11.instagramcomposable.navigation

sealed class Routes(val route: String) {
    object ScreenOne: Routes("screen_1")
    object ScreenTwo: Routes("screen_2")
    object ScreenThree: Routes("screen_3")
    object ScreenFour: Routes("screen_4/{number}") {
        fun createRoute(number: Int) = "screen_4/$number"
    }
}