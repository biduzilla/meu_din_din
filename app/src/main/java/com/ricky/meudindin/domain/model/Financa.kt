package com.ricky.meudindin.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDate

@Entity
data class Financa(
    @PrimaryKey
    var id:Long = 0L,
    var entrada:BigDecimal = BigDecimal.ZERO,
    var saida:BigDecimal = BigDecimal.ZERO,
    var data:LocalDate = LocalDate.now(),
)
