package com.ricky.meudindin.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ricky.meudindin.R
import com.ricky.meudindin.presentation.home.components.CardDespesa
import com.ricky.meudindin.presentation.home.components.DialogForm
import com.ricky.meudindin.presentation.home.components.TopBarHome

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit
) {

    if (state.isShowDialog) {
        DialogForm(
            titulo = state.titulo,
            valor = state.valor,
            tipo = state.tipo.value,
            onChangeTitulo = { onEvent(HomeEvent.OnChangeTitulo(it)) },
            onChangeValor = { onEvent(HomeEvent.OnChangeValor(it)) },
            onChangeTipo = { onEvent(HomeEvent.OnChangeTipo(it)) },
            onSave = { onEvent(HomeEvent.OnSave(it)) },
            isErrorValor = state.isErrorValor,
            isErrorTitulo = state.isErrorTitulo,
            onDismiss = { onEvent(HomeEvent.IsShowDialog(false)) }
        )
    }

    Scaffold(topBar = {
        TopBarHome(
            total = state.total,
            entrada = state.entrada,
            saida = state.saida
        )
    }, floatingActionButton = {
        FloatingActionButton(onClick = { onEvent(HomeEvent.IsShowDialog(true)) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Text(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                    text = stringResource(id = R.string.minhas_despesas),
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            items(state.despesas) { despesa ->
                CardDespesa(
                    modifier = Modifier.padding(16.dp),
                    despesa = despesa,
                    onDelete = { onEvent(HomeEvent.OnDelete(despesa.id)) })
            }
        }
    }
}