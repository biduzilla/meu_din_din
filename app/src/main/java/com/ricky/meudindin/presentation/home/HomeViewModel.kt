package com.ricky.meudindin.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.meudindin.domain.enums.TipoDespesa
import com.ricky.meudindin.domain.model.Despesa
import com.ricky.meudindin.domain.model.Financa
import com.ricky.meudindin.domain.model.despesaToDto
import com.ricky.meudindin.domain.repository.DespesaRepository
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
class HomeViewModel @Inject constructor(
    private val financaRepository: FinancaRepository,
    private val despesaRepository: DespesaRepository
) :
    ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        total()
        entradaMes()
        saidaMes()
        recuperaDespesas()
    }

    private fun recuperaDespesas() {
        viewModelScope.launch {
            despesaRepository.getAllDespesas().collect { despesas ->
                _state.update { currentState ->
                    currentState.copy(
                        despesas = despesas.map { it.despesaToDto() }
                    )
                }
            }
        }
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

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.IsShowDialog -> {
                _state.update {
                    it.copy(
                        isShowDialog = event.isShow
                    )
                }
            }

            is HomeEvent.OnChangeTipo -> {
                _state.update {
                    it.copy(
                        tipo = event.tipo
                    )
                }
            }

            is HomeEvent.OnChangeTitulo -> {
                _state.update {
                    it.copy(
                        titulo = event.titulo,
                        isErrorTitulo = false,
                    )
                }
            }

            is HomeEvent.OnChangeValor -> {
                val valor = event.valor.replace(",", ".")

                _state.update {
                    it.copy(
                        valor = valor,
                        isErrorValor = false
                    )
                }
            }

            is HomeEvent.OnSave -> {
                if (_state.value.titulo.isBlank() && event.form == 3) {
                    _state.update {
                        it.copy(
                            isErrorTitulo = true
                        )
                    }
                    return
                }
                if (_state.value.valor.count { it == '.' } > 1) {
                    _state.update {
                        it.copy(
                            isErrorValor = true
                        )
                    }
                    return
                }
                when (event.form) {
                    1 -> {
                        val financa = Financa(
                            entrada = BigDecimal(_state.value.valor),
                            saida = BigDecimal.ZERO,
                            data = LocalDate.now(),
                        )

                        viewModelScope.launch {
                            financaRepository.insertFinanca(financa)
                        }
                    }

                    2 -> {
                        val financa = Financa(
                            entrada = BigDecimal.ZERO,
                            saida = BigDecimal(_state.value.valor),
                            data = LocalDate.now(),
                            tipo = _state.value.tipo
                        )

                        viewModelScope.launch {
                            financaRepository.insertFinanca(financa)
                        }
                    }

                    3 -> {
                        val despesa = Despesa(
                            titulo = _state.value.titulo,
                            valor = BigDecimal(_state.value.valor),
                            tipo = _state.value.tipo,
                        )

                        viewModelScope.launch {
                            despesaRepository.insertDespesa(despesa)
                        }
                    }
                }
                _state.update {
                    it.copy(
                        isShowDialog = false,
                        tipo = TipoDespesa.OUTROS,
                        titulo = "",
                        valor = "",
                        isErrorValor = false,
                        isErrorTitulo = false,
                    )
                }
            }

            is HomeEvent.OnDelete -> {
                viewModelScope.launch {
                    despesaRepository.deleteDespesaById(event.id)
                }
            }
        }
    }
}