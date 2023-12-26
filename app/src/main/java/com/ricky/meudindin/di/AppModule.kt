package com.ricky.meudindin.di

import android.content.Context
import androidx.room.Room
import com.ricky.meudindin.common.DataStoreUtil
import com.ricky.meudindin.data.AppDatabase
import com.ricky.meudindin.data.dao.DespesaDao
import com.ricky.meudindin.data.dao.FinancaDao
import com.ricky.meudindin.data.repository.DespesaRepositoryImpl
import com.ricky.meudindin.data.repository.FinancaRepositoryImpl
import com.ricky.meudindin.domain.repository.DespesaRepository
import com.ricky.meudindin.domain.repository.FinancaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFinancaDao(database: AppDatabase): FinancaDao = database.financaDao()

    @Singleton
    @Provides
    fun provideDespesaDao(database: AppDatabase): DespesaDao = database.despesaDao()

    @Singleton
    @Provides
    fun provideFinancaRepository(dao: FinancaDao): FinancaRepository = FinancaRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideDespesaRepository(dao: DespesaDao): DespesaRepository = DespesaRepositoryImpl(dao)

    @Singleton
    @Provides
    fun provideDataStoreUtil(@ApplicationContext context: Context): DataStoreUtil =
        DataStoreUtil(context)

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        ).fallbackToDestructiveMigration()
            .build()
}