package com.ricky.meudindin.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ricky.meudindin.domain.enums.TipoDespesa
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class Despesa(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var titulo: String = "",
    var valor: BigDecimal = BigDecimal.ZERO,
    var data: LocalDate = LocalDate.now(),
    var tipo: TipoDespesa = TipoDespesa.OUTROS
)
