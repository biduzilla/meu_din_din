package com.ricky.meudindin.navigation

import android.window.SplashScreen
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ricky.meudindin.presentation.main.MainScreen
import com.ricky.meudindin.presentation.main.MainViewModel
import com.ricky.meudindin.presentation.splash.SplashScreen
import com.ricky.meudindin.presentation.splash.SplashViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNav() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController = navController, startDestination = Screens.SpashScreen.route) {
        composableSlideHorizontally(Screens.SpashScreen.route) {
            val viewModel = hiltViewModel<SplashViewModel>()
            val state by viewModel.state.collectAsState()

            SplashScreen(
                state = state,
                navController = navController
            )
        }

        composableSlideHorizontally(Screens.MainScreen.route) {
            val viewModel = hiltViewModel<MainViewModel>()
            val state by viewModel.state.collectAsState()

            MainScreen(state = state, onEvent = viewModel::onEvent)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.composableSlideHorizontally(
    route: String,
    duration: Int = 400, // 1000 - 400
    enterOffset: Int = 700, // 300 - 1000
    exitOffset: Int = -700,
    popEnterOffset: Int = -700,
    popExitOffset: Int = 700,
    screen: @Composable () -> Unit
) {
    composable(
        route = route,
        enterTransition = { slideInHorizontally(tween(duration)) { enterOffset } },
        exitTransition = { slideOutHorizontally(tween(duration)) { exitOffset } },
        popEnterTransition = { slideInHorizontally(tween(duration)) { popEnterOffset } },
        popExitTransition = { slideOutHorizontally(tween(duration)) { popExitOffset } },
        content = { screen() }
    )
}