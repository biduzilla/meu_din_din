package com.ricky.meudindin.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ricky.meudindin.presentation.home.components.TopBarHome

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(state: HomeState) {
    Scaffold(topBar = {
        TopBarHome(
            total = state.total,
            entrada = state.entrada,
            saida = state.saida
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick = { }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {}
    }
}