package com.example.mybank.presentation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mybank.core.navigation.ScreenRoutes
import com.example.mybank.presentation.auth.login.LoginScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = ScreenRoutes.LoginScreen.route,
        enterTransition = {
            slideInHorizontally(tween(700)) { 1090 }
        },
        exitTransition = {
            slideOutHorizontally(tween(700)) { - 1090 }
        },
        popEnterTransition = {
            slideInHorizontally(tween(700)) { 1090 }
        },
        popExitTransition = {
            slideOutHorizontally(tween(700)) { - 1090 }
        },
        ){
        // Auth
        composable(route = ScreenRoutes.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route = ScreenRoutes.RegisterScreen.route){
//            RegisterScreen(navController = navController)
        }

        // Home
        composable(route = ScreenRoutes.HomeScreen.route){
//            HomeScreen(navController = navController)
        }
        composable(route = ScreenRoutes.MovementScreen.route){
//            MovementScreen(navController = navController)
        }
    }
}