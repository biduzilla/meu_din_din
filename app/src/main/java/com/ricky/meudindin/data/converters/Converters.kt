package com.ricky.meudindin.data.converters

import androidx.room.TypeConverter
import com.ricky.meudindin.domain.enum.TipoDespesa
import java.math.BigDecimal

class Converters {
    @TypeConverter
    fun fromTipoDespesa(tipoDespesa: TipoDespesa): String {
        return tipoDespesa.name
    }

    @TypeConverter
    fun toTipoDespesa(value: String): TipoDespesa {
        return enumValueOf(value)
    }

    @TypeConverter
    fun fromBigDecimal(value: BigDecimal?): String? {
        return value?.toString()
    }

    @TypeConverter
    fun toBigDecimal(value: String?): BigDecimal? {
        return value?.let { BigDecimal(it) }
    }
}