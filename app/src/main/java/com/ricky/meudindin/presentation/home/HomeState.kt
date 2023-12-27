package com.ricky.meudindin.presentation.home

import java.math.BigDecimal

data class HomeState(
    var total: BigDecimal = BigDecimal.ZERO,
    var entrada: BigDecimal = BigDecimal.ZERO,
    var saida: BigDecimal = BigDecimal.ZERO,
    var startData:Long = 0L,
    var endData:Long = 0L,
    var isShowDialog:Boolean = false,
)
