package com.ricky.meudindin.presentation.historico

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.meudindin.common.calculateDateAgo
import com.ricky.meudindin.domain.repository.FinancaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
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
            val startDate: Long
            val endDate: Long

            when (_state.value.filtro) {
                "7_dias" -> {
                    endDate = calculateDateAgo(7, Calendar.DAY_OF_YEAR)
                    startDate = calendar.timeInMillis
                }

                "14_dias" -> {
                    endDate = calculateDateAgo(14, Calendar.DAY_OF_YEAR)
                    startDate = calendar.timeInMillis
                }

                "1_mes" -> {
                    endDate = calculateDateAgo(1, Calendar.MONTH)
                    startDate = calendar.timeInMillis
                }

                "6_meses" -> {
                    endDate = calculateDateAgo(6, Calendar.MONTH)
                    startDate = calendar.timeInMillis
                }

                "1_ano" -> {
                    endDate = calculateDateAgo(1, Calendar.YEAR)
                    startDate = calendar.timeInMillis
                }

                "total" -> {
                    financaRepository.getAllFinanca().collect { financasRecuperadas ->
                        _state.update {
                            it.copy(
                                financas = financasRecuperadas
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
                _state.update {
                    it.copy(
                        financas = financasRecuperadas
                    )
                }
            }
        }
    }
}