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
}