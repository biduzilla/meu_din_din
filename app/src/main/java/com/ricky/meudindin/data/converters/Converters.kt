package com.ricky.meudindin.data.converters

import androidx.room.TypeConverter
import com.ricky.meudindin.domain.enums.TipoDespesa
import java.math.BigDecimal
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromTipoDespesa(tipoDespesa: TipoDespesa): String {
        return tipoDespesa.value
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

    @TypeConverter
    fun fromDate(date: LocalDate?): Long? {
        return date?.toEpochDay()
    }

    @TypeConverter
    fun toDate(epochDay: Long?): LocalDate? {
        return epochDay?.let { LocalDate.ofEpochDay(it) }
    }
}