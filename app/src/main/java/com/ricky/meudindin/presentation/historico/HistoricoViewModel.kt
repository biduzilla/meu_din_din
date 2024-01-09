package com.ricky.meudindin.presentation.historico

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.meudindin.common.calculateDateAgo
import com.ricky.meudindin.common.organizarPorTipo
import com.ricky.meudindin.domain.repository.FinancaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class HistoricoViewModel @Inject constructor(private val financaRepository: FinancaRepository) :
    ViewModel() {

    private val _state = MutableStateFlow(HistoricoState())
    val state = _state.asStateFlow()

    init {
        recuperaFinancas()
    }

    private fun recuperaFinancas() {
        viewModelScope.launch {
            val startDate: Long = LocalDate.now().toEpochDay()
            val endDate: Long

            when (_state.value.filtro) {
                "7_dias" -> {
                    endDate = calculateDateAgo(7, "days")
                }

                "14_dias" -> {
                    endDate = calculateDateAgo(14, "days")
                }

                "1_mes" -> {
                    endDate = calculateDateAgo(1, "months")
                }

                "6_meses" -> {
                    endDate = calculateDateAgo(6, "months")
                }

                "1_ano" -> {
                    endDate = calculateDateAgo(1, "years")
                }

                "total" -> {
                    financaRepository.getAllSaidaFinanca().collect { financasRecuperadas ->
                        _state.update {
                            it.copy(
                                financas =  organizarPorTipo(financasRecuperadas)
                            )
                        }
                    }
                    return@launch
                }

                else -> return@launch
            }

            financaRepository.getFinancaByDate(
                startDate = startDate,
                endDate = endDate
            ).collect { financasRecuperadas ->
                val financas = organizarPorTipo(financasRecuperadas)
                _state.update {
                    it.copy(
                        financas = financas
                    )
                }
            }
        }
    }

    fun onEvent(event: HistoricoEvent) {
        when (event) {
            is HistoricoEvent.OnChangeFiltro -> {
                _state.update {
                    it.copy(
                        filtro = event.filtro
                    )
                }
                recuperaFinancas()
            }
        }

    }
}