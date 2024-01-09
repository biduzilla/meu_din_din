package com.ricky.meudindin.presentation.historico

import com.ricky.meudindin.domain.model.Financa

data class HistoricoState(
    var filtro: String = "7_dias",
    var financas: List<Financa> = emptyList()
)
