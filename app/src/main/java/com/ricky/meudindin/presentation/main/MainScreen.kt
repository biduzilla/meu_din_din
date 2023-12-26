package com.ricky.meudindin.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ricky.meudindin.navigation.BottomNav
import com.ricky.meudindin.presentation.main.components.BottomBar
import com.ricky.meudindin.presentation.main.components.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    state: MainState,
    onEvent: (MainEvent) -> Unit
) {
    val navController = rememberNavController()

    Scaffold(topBar = {
        TopBar(isDark = state.isDark,
            onChangeTheme = { onEvent(MainEvent.OnChangeTheme(it)) })
    },
        bottomBar = {
            BottomBar(navController = navController)
        }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            BottomNav(navController = navController)
        }
    }
}