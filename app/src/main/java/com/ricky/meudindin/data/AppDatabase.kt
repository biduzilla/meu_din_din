package com.ricky.meudindin.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ricky.meudindin.data.converters.Converters
import com.ricky.meudindin.data.dao.DespesaDao
import com.ricky.meudindin.data.dao.FinancaDao
import com.ricky.meudindin.domain.model.Despesa
import com.ricky.meudindin.domain.model.Financa

@Database(
    entities = [
        Financa::class,
        Despesa::class
    ],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun financaDao(): FinancaDao
    abstract fun despesaDao(): DespesaDao
}