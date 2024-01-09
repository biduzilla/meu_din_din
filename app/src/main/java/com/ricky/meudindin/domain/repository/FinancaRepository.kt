package com.ricky.meudindin.domain.repository

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
    fun getTotal(): Flow<BigDecimal>
    fun sumEntradasByDate(startDate: Long, endDate: Long): Flow<BigDecimal>
    fun sumSaidaByDate(startDate: Long, endDate: Long): Flow<BigDecimal>
    fun getFinancaByDate(startDate: Long, endDate: Long): Flow<List<Financa>>
    fun getAllSaidaFinanca(): Flow<List<Financa>>
    fun sumSaidas(): Flow<BigDecimal>
    fun sumEntradas(): Flow<BigDecimal>
}