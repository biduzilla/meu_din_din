package com.ricky.meudindin.presentation.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricky.meudindin.ui.theme.MeuDinDInTheme

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    isDark: Boolean,
    onChangeTheme: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Switch(checked = isDark,
            onCheckedChange = { onChangeTheme(it) },
            thumbContent = {
                Icon(
                    imageVector = if (isDark) Icons.Default.DarkMode else Icons.Default.LightMode,
                    contentDescription = null
                )
            })
    }

}

@Preview
@Composable
private fun TopBarPreview() {
    MeuDinDInTheme {
        TopBar(isDark = true, onChangeTheme = {})
    }
}