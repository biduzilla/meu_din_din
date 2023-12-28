package com.ricky.meudindin.domain.enums

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.ui.graphics.vector.ImageVector

enum class TipoDespesa(val value: String, val icon: ImageVector) {
    ALUGUEL("Aluguel", Icons.Default.Home),
    LUZ("Luz", Icons.Default.Bolt),
    AGUA("Água", Icons.Default.WaterDrop),
    GAS("Gás", Icons.Default.LocalFireDepartment),
    INTERNET("Internet", Icons.Default.Wifi),
    TELEFONE("Telefone", Icons.Default.Phone),
    SUPERMERCADO("Supermecado", Icons.Default.ShoppingCart),
    TRANSPORTE("Transporte", Icons.Default.DirectionsCar),
    SAUDE("Saúde", Icons.Default.HealthAndSafety),
    EDUCACAO("Educação", Icons.Default.MenuBook),
    LAZER("Lazer", Icons.Default.Mood),
    ACADEMIA("Academia", Icons.Default.FitnessCenter),
    OUTROS("Outros", Icons.Default.ShoppingBag)
}