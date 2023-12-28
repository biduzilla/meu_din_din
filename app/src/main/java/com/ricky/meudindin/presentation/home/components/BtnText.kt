package com.ricky.meudindin.presentation.home.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BtnText(
    modifier: Modifier = Modifier,
    @StringRes label: Int,
    onClick: () -> Unit,
    isPress: Boolean
) {
    Button(
        modifier = modifier.padding(end = 4.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.outline.takeIf { isPress }
                ?: MaterialTheme.colorScheme.outlineVariant
        )
    ) {
        Text(
            text = stringResource(id = label),
            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer)
        )
    }
}