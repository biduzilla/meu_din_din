package com.ricky.meudindin.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Handyman
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricky.meudindin.domain.dto.DespesaDto
import com.ricky.meudindin.ui.theme.MeuDinDInTheme

@Composable
fun CardDespesa(
    modifier: Modifier = Modifier,
    despesa: DespesaDto,
    onDelete: () -> Unit
) {
    var isShowDialog by remember {
        mutableStateOf(false)
    }


    if (isShowDialog) {
        DialogRemover(
            onDismiss = { isShowDialog = false },
            onRemover = {
                onDelete()
                isShowDialog = false
            }
        )
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier.weight(1.5f),
                    shape = CircleShape
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(50.dp),
                        imageVector = despesa.icon,
                        contentDescription = despesa.titulo
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(4f)) {
                    Text(
                        text = despesa.titulo,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "R$ ${despesa.valor}",
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                }
                IconButton(modifier = Modifier.padding(8.dp),
                    onClick = {
                        isShowDialog = true
                    }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                }
            }
        }
    }
}

@Preview
@Composable
private fun CardDespesaPreview() {
    MeuDinDInTheme {
        CardDespesa(despesa = DespesaDto(titulo = "titulo", icon = Icons.Default.Handyman)) {

        }
    }
}