package com.arifali.schoolteacherappui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.arifali.schoolteacherappui.ui.theme.CartScreen
import com.arifali.schoolteacherappui.ui.theme.DetailsScreen
import com.arifali.schoolteacherappui.ui.theme.HomeScreen
import com.arifali.schoolteacherappui.ui.theme.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.WelcomeScreen.name,
    ) {
        composable(Route.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(Route.WelcomeScreen.name) {
            WelcomeScreen(navController,isBackgroundOne = false)
        }
        composable(Route.DetailsScreen.name) {
            DetailsScreen(navController)
        }
        composable(Route.CartScreen.name) {
            CartScreen(navController)
        }
    }
}
