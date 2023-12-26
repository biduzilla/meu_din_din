package com.ricky.meudindin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun BottomNav(navController: NavHostController) {
    NavHost(navController = navController,  startDestination = BottomScreens.HomeScreen.route){
        composable(BottomScreens.HomeScreen.route){

        }

        composable(BottomScreens.HistoricoScreen.route){

        }
    }
}