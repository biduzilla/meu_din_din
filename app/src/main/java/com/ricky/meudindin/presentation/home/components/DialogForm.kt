package com.ricky.meudindin.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ricky.meudindin.R
import com.ricky.meudindin.domain.enum.TipoDespesa
import com.ricky.meudindin.presentation.main.components.BtnText
import com.ricky.meudindin.presentation.main.components.DropdownCompose
import com.ricky.meudindin.ui.theme.MeuDinDInTheme

@Composable
fun DialogForm(
    modifier: Modifier = Modifier,
    titulo: String,
    valor: String,
    tipo: String,
    onChangeTitulo: (String) -> Unit,
    onChangeValor: (String) -> Unit,
    onChangeTipo: (String) -> Unit,
    onSave: () -> Unit,
    onErrorTitulo: Boolean,
    onDismiss: () -> Unit
) {
    var form by remember {
        mutableStateOf(1)
    }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(8.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    BtnText(label = R.string.entrada, onClick = { form = 1 }, isPress = form == 1)
                    BtnText(label = R.string.saida, onClick = { form = 2 }, isPress = form == 2)
                    BtnText(label = R.string.despesa, onClick = { form = 3 }, isPress = form == 3)
                }
                if (form == 3) {
                    TextFieldCompose(
                        value = titulo,
                        isError = onErrorTitulo,
                        label = R.string.titulo,
                        onChange = { onChangeTitulo(it) })

                }
                TextFieldCompose(
                    value = valor,
                    isError = false,
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

                Button(onClick = onSave) {
                    Text(
                        text = stringResource(id = R.string.salvar),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
