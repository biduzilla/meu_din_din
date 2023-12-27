package com.ricky.meudindin.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.ricky.meudindin.domain.model.Financa
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

interface FinancaRepository {
    fun getAllFinanca(): Flow<List<Financa>>
    suspend fun getFinancaById(idFinanca: Long): Financa
    suspend fun insertFinanca(financa: Financa)
    suspend fun updateFinanca(financa: Financa)
    suspend fun deleteFinanca(financa: Financa)
    suspend fun deleteFinancaById(idFinanca: Long)
    suspend fun calcularTotal(): BigDecimal
    suspend fun sumEntradasByDate(startDate: Long, endDate: Long): BigDecimal
    suspend fun sumSaidaByDate(startDate: Long, endDate: Long): BigDecimal
}