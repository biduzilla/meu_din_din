package com.ricky.meudindin.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.ricky.meudindin.domain.model.Despesa
import kotlinx.coroutines.flow.Flow

@Dao
interface DespesaDao {
    @Query("SELECT * FROM DESPESA")
    fun getAllDespesas(): Flow<List<Despesa>>

    @Query("SELECT * FROM DESPESA WHERE id= :idDespesa")
    suspend fun getDespesaById(idDespesa: Long): Despesa

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDespesa(despesa: Despesa)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateDespesa(despesa: Despesa)

    @Delete
    suspend fun deleteDespesa(despesa: Despesa)

    @Transaction
    @Query("DELETE FROM DESPESA WHERE id = :idDespesa")
    suspend fun deleteDespesaById(idDespesa: Despesa)
}