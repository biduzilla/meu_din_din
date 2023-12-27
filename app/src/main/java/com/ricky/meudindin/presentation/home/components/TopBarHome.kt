package com.ricky.meudindin.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ricky.meudindin.R
import com.ricky.meudindin.ui.theme.MeuDinDInTheme
import java.math.BigDecimal

@Composable
fun TopBarHome(
    modifier: Modifier = Modifier,
    total: BigDecimal,
    entrada: BigDecimal,
    saida: BigDecimal
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(
            bottomEnd = 20.dp,
            bottomStart = 20.dp
        ),
        color = MaterialTheme.colorScheme.primary
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = stringResource(id = R.string.total),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
            )
            Text(
                text = "R$ $total",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = stringResource(id = R.string.mes_ultimo),
                style = TextStyle(
                    fontSize = 18.sp,
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "+ R$ $entrada",
                        style = TextStyle(
                            fontSize = 22.sp,
                            color = Color.Green
                        ),
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "- R$ $saida",
                        style = TextStyle(
                            fontSize = 22.sp,
                            color = Color.Red
                        ),
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TopBarHomePreview() {
    MeuDinDInTheme {
        TopBarHome(total = BigDecimal.ZERO, entrada = BigDecimal.ZERO, saida = BigDecimal.ZERO)
    }
}