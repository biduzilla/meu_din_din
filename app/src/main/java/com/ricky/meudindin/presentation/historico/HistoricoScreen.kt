package com.ricky.meudindin.presentation.historico

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ricky.meudindin.R
import com.ricky.meudindin.presentation.historico.components.CardGasto
import com.ricky.meudindin.presentation.historico.components.DespesaItem
import com.ricky.meudindin.presentation.home.components.BtnText

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HistoricoScreen(state: HistoricoState, onEvent: (HistoricoEvent) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.gastos), style =
                TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                thickness = 2.dp
            )
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                BtnText(
                    label = R.string.sete_dias,
                    onClick = { onEvent(HistoricoEvent.OnChangeFiltro("7_dias")) },
                    isPress = state.filtro == "7_dias"
                )
                BtnText(
                    label = R.string.cartorze_dias,
                    onClick = { onEvent(HistoricoEvent.OnChangeFiltro("14_dias")) },
                    isPress = state.filtro == "14_dias"
                )
                BtnText(
                    label = R.string.um_mes,
                    onClick = { onEvent(HistoricoEvent.OnChangeFiltro("1_mes")) },
                    isPress = state.filtro == "1_mes"
                )
                BtnText(
                    label = R.string.seis_meses,
                    onClick = { onEvent(HistoricoEvent.OnChangeFiltro("6_meses")) },
                    isPress = state.filtro == "6_meses"
                )
                BtnText(
                    label = R.string.um_ano,
                    onClick = { onEvent(HistoricoEvent.OnChangeFiltro("1_ano")) },
                    isPress = state.filtro == "1_ano"
                )
                BtnText(
                    label = R.string.total,
                    onClick = { onEvent(HistoricoEvent.OnChangeFiltro("total")) },
                    isPress = state.filtro == "total"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
        items(state.financas) { item ->
            CardGasto(financa = item)
        }
        item {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "Total de gastos: R$ ${state.saida}",
                        style = TextStyle(
                            fontSize = 22.sp,
                            color = Color.Red
                        ),
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
            }
            Text(
                text = stringResource(id = R.string.historico), style =
                TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                thickness = 2.dp
            )
        }
        items(state.despesas) { item ->
            Text(
                text = item.mesAno,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))
            item.despesas.forEach { financa ->
                DespesaItem(financa = financa)
            }
        }
    }
}