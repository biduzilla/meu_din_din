package com.ricky.meudindin.domain.repository

import com.ricky.meudindin.domain.model.Despesa
import kotlinx.coroutines.flow.Flow

interface DespesaRepository {
    fun getAllDespesas(): Flow<List<Despesa>>
    suspend fun getDespesaById(idDespesa: Long): Despesa
    suspend fun insertDespesa(despesa: Despesa)
    suspend fun updateDespesa(despesa: Despesa)
    suspend fun deleteDespesa(despesa: Despesa)
    suspend fun deleteDespesaById(idDespesa: Despesa)
}