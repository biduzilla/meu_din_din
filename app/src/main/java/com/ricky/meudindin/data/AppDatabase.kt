package com.ricky.meudindin.data

import androidx.room.Database
import com.ricky.meudindin.data.dao.DespesaDao
import com.ricky.meudindin.data.dao.FinancaDao
import com.ricky.meudindin.domain.model.Despesa
import com.ricky.meudindin.domain.model.Financa

@Database(
    entities = [
        Financa::class,
        Despesa::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase {
    abstract fun financaDao(): FinancaDao
    abstract fun despesaDao(): DespesaDao
}