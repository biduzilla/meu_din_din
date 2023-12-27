package com.ricky.meudindin.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ricky.meudindin.presentation.home.HomeScreen
import com.ricky.meudindin.presentation.home.HomeViewModel

@Composable
fun BottomNav(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomScreens.HomeScreen.route) {
        composable(BottomScreens.HomeScreen.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            val state by viewModel.state.collectAsState()

            HomeScreen(state = state)
        }

        composable(BottomScreens.HistoricoScreen.route) {

        }
    }
}