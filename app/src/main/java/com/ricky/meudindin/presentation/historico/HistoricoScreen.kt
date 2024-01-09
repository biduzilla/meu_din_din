package com.ricky.meudindin.presentation.historico

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ricky.meudindin.R
import com.ricky.meudindin.presentation.home.components.BtnText

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HistoricoScreen(state: HistoricoState, onEvent: (HistoricoEvent) -> Unit) {
    FlowRow {
        BtnText(
            label = R.string.sete_dias,
            onClick = { onEvent(HistoricoEvent.OnChangeFiltro(7)) },
            isPress = state.filtro == "7_dias"
        )
        BtnText(
            label = R.string.cartorze_dias,
            onClick = { onEvent(HistoricoEvent.OnChangeFiltro(7)) },
            isPress = state.filtro == "14_dias"
        )
        BtnText(
            label = R.string.um_mes,
            onClick = { onEvent(HistoricoEvent.OnChangeFiltro(7)) },
            isPress = state.filtro == "1_mes"
        )
        BtnText(
            label = R.string.seis_meses,
            onClick = { onEvent(HistoricoEvent.OnChangeFiltro(7)) },
            isPress = state.filtro == "6_meses"
        )
        BtnText(
            label = R.string.um_ano,
            onClick = { onEvent(HistoricoEvent.OnChangeFiltro(7)) },
            isPress = state.filtro == "1_ano"
        )
        BtnText(
            label = R.string.total,
            onClick = { onEvent(HistoricoEvent.OnChangeFiltro(7)) },
            isPress = state.filtro == "total"
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}