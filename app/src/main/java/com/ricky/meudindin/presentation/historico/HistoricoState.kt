package com.ricky.meudindin.presentation.historico

import com.ricky.meudindin.domain.model.Financa
import java.math.BigDecimal

data class HistoricoState(
    var filtro: String = "7_dias",
    var financas: List<Financa> = emptyList(),
    var entrada: BigDecimal = BigDecimal.ZERO,
    var saida: BigDecimal = BigDecimal.ZERO,
)
