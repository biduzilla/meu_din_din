package com.ricky.meudindin.data.repository

import com.ricky.meudindin.data.dao.DespesaDao
import com.ricky.meudindin.domain.model.Despesa
import com.ricky.meudindin.domain.repository.DespesaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DespesaRepositoryImpl @Inject constructor(private val dao: DespesaDao) : DespesaRepository {
    override fun getAllDespesas(): Flow<List<Despesa>> = dao.getAllDespesas()

    override suspend fun getDespesaById(idDespesa: Long): Despesa = dao.getDespesaById(idDespesa)

    override suspend fun updateDespesa(despesa: Despesa) = dao.updateDespesa(despesa)

    override suspend fun deleteDespesa(despesa: Despesa) = dao.deleteDespesa(despesa)

    override suspend fun insertDespesa(despesa: Despesa) = dao.insertDespesa(despesa)

    override suspend fun deleteDespesaById(idDespesa: Despesa) = dao.deleteDespesaById(idDespesa)
}