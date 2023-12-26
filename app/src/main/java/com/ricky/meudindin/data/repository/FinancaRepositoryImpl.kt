package com.ricky.meudindin.data.repository

import com.ricky.meudindin.data.dao.FinancaDao
import com.ricky.meudindin.domain.model.Financa
import com.ricky.meudindin.domain.repository.FinancaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FinancaRepositoryImpl @Inject constructor(private val dao: FinancaDao) : FinancaRepository {
    override fun getAllFinanca(): Flow<List<Financa>> = dao.getAllFinanca()

    override suspend fun getFinancaById(idFinanca: Long): Financa = dao.getFinancaById(idFinanca)

    override suspend fun insertFinanca(financa: Financa) = dao.insertFinanca(financa)

    override suspend fun updateFinanca(financa: Financa) = dao.updateFinanca(financa)

    override suspend fun deleteFinanca(financa: Financa) = dao.deleteFinanca(financa)

    override suspend fun deleteFinancaById(idFinanca: Long) = dao.deleteFinancaById(idFinanca)
}