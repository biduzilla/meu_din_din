package com.ricky.meudindin.presentation.main.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ricky.meudindin.navigation.BottomScreens

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf(
        BottomScreens.HomeScreen,
        BottomScreens.HistoricoScreen,
    )

    NavigationBar {
        val navb by navController.currentBackStackEntryAsState()
        val currentRoute = navb?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                selected = screen.route == currentRoute,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = { Text(text = screen.route) },
                icon = {
                    Icon(
                        imageVector = if (screen.route == currentRoute) screen.selectedIcon else screen.unselectedIcon,
                        contentDescription = screen.route
                    )
                })
        }
    }
}