package com.ricky.meudindin.presentation.home

import android.icu.util.LocaleData
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.meudindin.domain.repository.FinancaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val financaRepository: FinancaRepository) :
    ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        total()
        entradaMes()
        saidaMes()
    }

    private fun saidaMes() {
        val startDate = LocalDate.now().minusDays(29).toEpochDay()
        val endDate = LocalDate.now().toEpochDay()

        viewModelScope.launch {
            financaRepository.sumSaidaByDate(
                startDate = startDate,
                endDate = endDate
            ).collect { saidaTotal ->
                _state.update {
                    it.copy(
                        saida = saidaTotal ?: BigDecimal.ZERO
                    )
                }
            }
        }
    }

    private fun entradaMes() {
        val startDate = LocalDate.now().minusDays(29).toEpochDay()
        val endDate = LocalDate.now().toEpochDay()

        viewModelScope.launch {
            financaRepository.sumEntradasByDate(
                startDate = startDate,
                endDate = endDate
            ).collect { entradaTotal ->
                _state.update {
                    it.copy(
                        entrada = entradaTotal ?: BigDecimal.ZERO
                    )
                }
            }
        }
    }

    private fun total() {
        viewModelScope.launch {
            financaRepository.getTotal().collect { total ->
                _state.update {
                    it.copy(
                        total = total ?: BigDecimal.ZERO
                    )
                }
            }
        }
    }
}