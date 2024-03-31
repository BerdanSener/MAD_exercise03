package com.example.movieappmad24.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.movieappmad24.scenes.DetailScreen
import com.example.movieappmad24.scenes.HomeScreen


sealed class Screen(val route: String) {
    object Home : Screen("homescreen")
    object Details : Screen("detailscreen")
}


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Details.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.StringType })) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            DetailScreen(movieId = movieId, navController = navController)
        }
    }
}
