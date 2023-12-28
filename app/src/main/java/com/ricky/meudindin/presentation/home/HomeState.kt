package com.ricky.meudindin.presentation.home

import com.ricky.meudindin.domain.enums.TipoDespesa
import com.ricky.meudindin.domain.model.Despesa
import java.math.BigDecimal

data class HomeState(
    var despesas: List<Despesa> = emptyList(),
    var total: BigDecimal = BigDecimal.ZERO,
    var entrada: BigDecimal = BigDecimal.ZERO,
    var saida: BigDecimal = BigDecimal.ZERO,
    var valor: String = "",
    var titulo: String = "",
    var tipo: TipoDespesa = TipoDespesa.OUTROS,
    var isErrorTitulo: Boolean = false,
    var isErrorValor: Boolean = false,
    var isShowDialog: Boolean = false,
)
