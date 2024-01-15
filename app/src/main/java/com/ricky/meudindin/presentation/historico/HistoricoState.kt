package com.ricky.meudindin.presentation.historico

import com.ricky.meudindin.domain.dto.FinancaMesAno
import com.ricky.meudindin.domain.model.Financa
import java.math.BigDecimal

data class HistoricoState(
    var despesas:List<FinancaMesAno> = emptyList(),
    var filtro: String = "7_dias",
    var financas: List<Financa> = emptyList(),
    var entrada: BigDecimal = BigDecimal.ZERO,
    var saida: BigDecimal = BigDecimal.ZERO,
)
