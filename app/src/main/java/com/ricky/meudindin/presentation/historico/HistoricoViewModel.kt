package com.ricky.meudindin.presentation.historico

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.meudindin.domain.repository.FinancaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HistoricoViewModel @Inject constructor(private val financaRepository: FinancaRepository) :
    ViewModel() {

    private val _state = MutableStateFlow(HistoricoState())
    val state = _state.asStateFlow()
    private val calendar = Calendar.getInstance()

    init {
        recuperaFinancas()
    }

    private fun recuperaFinancas() {
        viewModelScope.launch {
            when (_state.value.filtro) {
                "7_dias" -> {

                }
            }

        }
    }
}