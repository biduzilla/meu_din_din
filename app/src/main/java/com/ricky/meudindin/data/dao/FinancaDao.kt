package com.ricky.meudindin.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.ricky.meudindin.domain.model.Financa
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

@Dao
interface FinancaDao {
    @Query("SELECT * FROM FINANCA")
    fun getAllFinanca(): Flow<List<Financa>>

    @Query("SELECT * FROM FINANCA WHERE id = :idFinanca")
    suspend fun getFinancaById(idFinanca: Long): Financa

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFinanca(financa: Financa)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFinanca(financa: Financa)

    @Delete
    suspend fun deleteFinanca(financa: Financa)

    @Transaction
    @Query("DELETE FROM FINANCA WHERE id = :idFinanca")
    suspend fun deleteFinancaById(idFinanca: Long)

    @Query("SELECT SUM(entrada) - SUM(saida) AS total FROM FINANCA")
    fun getTotal(): Flow<BigDecimal>

    @Query("SELECT SUM(entrada) AS total FROM FINANCA WHERE data BETWEEN :endDate AND :startDate")
    fun sumEntradasByDate(startDate: Long, endDate: Long): Flow<BigDecimal>

    @Query("SELECT SUM(entrada) AS total FROM FINANCA")
    fun sumEntradas(): Flow<BigDecimal>

    @Query("SELECT SUM(saida) AS total FROM FINANCA")
    fun sumSaidas(): Flow<BigDecimal>

    @Query("SELECT SUM(saida)  AS total FROM FINANCA WHERE data BETWEEN :endDate AND :startDate")
    fun sumSaidaByDate(startDate: Long, endDate: Long): Flow<BigDecimal>

    @Query("SELECT * FROM FINANCA WHERE data BETWEEN :endDate AND :startDate AND saida > 0 ORDER BY saida DESC")
    fun getFinancaByDate(startDate: Long, endDate: Long): Flow<List<Financa>>

    @Query("SELECT * FROM FINANCA WHERE saida > 0 ORDER BY saida DESC")
    fun getAllSaidaFinanca(): Flow<List<Financa>>

}