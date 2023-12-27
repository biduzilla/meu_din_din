package com.ricky.meudindin.presentation.home

import java.math.BigDecimal

data class HomeState(
    var total: BigDecimal = BigDecimal.ZERO,
    var entrada: BigDecimal = BigDecimal.ZERO,
    var saida: BigDecimal = BigDecimal.ZERO,
    var isShowDialog: Boolean = false,
    var valor: BigDecimal = BigDecimal.ZERO,
    var isErrorValor: Boolean = false,
)
