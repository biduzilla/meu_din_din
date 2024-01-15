package com.ricky.meudindin.domain.dto

import com.ricky.meudindin.domain.model.Financa

data class FinancaMesAno(
    var despesas: List<Financa> = emptyList(),
    var mesAno: String = ""
)
