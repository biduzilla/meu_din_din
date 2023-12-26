package com.ricky.meudindin.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreens(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {

    object HomeScreen : BottomScreens(
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    object HistoricoScreen : BottomScreens(
        route = "historico",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )
}