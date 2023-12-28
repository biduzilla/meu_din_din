package com.ricky.meudindin.presentation.home.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ricky.meudindin.R
import com.ricky.meudindin.domain.enums.TipoDespesa
import com.ricky.meudindin.ui.theme.MeuDinDInTheme

@Composable
fun DialogForm(
    modifier: Modifier = Modifier,
    titulo: String,
    valor: String,
    tipo: String,
    onChangeTitulo: (String) -> Unit,
    onChangeValor: (String) -> Unit,
    onChangeTipo: (TipoDespesa) -> Unit,
    onSave: (Int) -> Unit,
    isErrorTitulo: Boolean,
    isErrorValor: Boolean,
    onDismiss: () -> Unit
) {
    var form by remember {
        mutableStateOf(3)
    }

    Dialog(onDismissRequest = onDismiss) {
        Box(
            modifier = Modifier
        ) {
            Card(
                modifier = modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                    .align(Alignment.Center),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()

                ) {
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        BtnText(
                            label = R.string.entrada,
                            onClick = { form = 1 },
                            isPress = form == 1
                        )
                        BtnText(label = R.string.saida, onClick = { form = 2 }, isPress = form == 2)
                        BtnText(
                            label = R.string.despesa,
                            onClick = { form = 3 },
                            isPress = form == 3
                        )
                    }
                    if (form == 3) {
                        TextFieldCompose(
                            value = titulo,
                            isError = isErrorTitulo,
                            label = R.string.titulo,
                            onChange = { onChangeTitulo(it) })

                    }
                    TextFieldCompose(
                        value = valor,
                        isError = isErrorValor,
                        label = R.string.valor,
                        onChange = { onChangeValor(it) },
                        keyboardType = KeyboardType.Decimal
                    )
                    if (form != 1) {
                        DropdownCompose(
                            value = tipo,
                            list = TipoDespesa.values().toList(),
                            onChange = { onChangeTipo(it) })
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = { onSave(form) }) {
                        Text(
                            text = stringResource(id = R.string.salvar),
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DialogFormPreview() {
    MeuDinDInTheme {
        DialogForm(
            titulo = "titulo",
            valor = "0.00",
            tipo = TipoDespesa.AGUA.value,
            onChangeTitulo = {},
            onChangeValor = {},
            onChangeTipo = {},
            onSave = {},
            isErrorTitulo = false,
            isErrorValor = false,
        ) {

        }
    }
}
