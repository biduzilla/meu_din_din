package com.ricky.meudindin.domain.dto

import androidx.compose.ui.graphics.vector.ImageVector
import java.math.BigDecimal

data class DespesaDto(
    var titulo: String = "",
    var valor: BigDecimal = BigDecimal.ZERO,
    var icon: ImageVector
)

