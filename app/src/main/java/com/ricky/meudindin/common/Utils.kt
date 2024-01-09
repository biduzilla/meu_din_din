package com.ricky.meudindin.common

import com.ricky.meudindin.domain.enums.TipoDespesa
import com.ricky.meudindin.domain.model.Financa
import java.time.LocalDate
import java.util.Calendar

fun calculateDateAgo(amount: Int, unit: String): Long {
    val currentDate = LocalDate.now()

    return when (unit) {
        "days" -> currentDate.minusDays(amount.toLong()).toEpochDay()
        "months" -> currentDate.minusMonths(amount.toLong()).toEpochDay()
        "years" -> currentDate.minusYears(amount.toLong()).toEpochDay()
        else -> currentDate.toEpochDay()
    }
}

fun organizarPorTipo(financas: List<Financa>): List<Financa> {
    val financasPorTipoMap = mutableMapOf<TipoDespesa, Financa>()

    for (financa in financas) {
        val tipo = financa.tipo ?: TipoDespesa.OUTROS
        val existingFinancasPorTipo = financasPorTipoMap[tipo]

        val totalEntrada =
            existingFinancasPorTipo?.entrada?.plus(financa.entrada) ?: financa.entrada
        val totalSaida = existingFinancasPorTipo?.saida?.plus(financa.saida) ?: financa.saida

        financasPorTipoMap[tipo] = Financa(tipo = tipo, entrada = totalEntrada, saida = totalSaida)
    }

    return financasPorTipoMap.values.toList()
}