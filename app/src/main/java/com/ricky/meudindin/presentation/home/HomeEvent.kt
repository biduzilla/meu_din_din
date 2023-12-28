package com.ricky.meudindin.presentation.home

import com.ricky.meudindin.domain.enums.TipoDespesa

sealed interface HomeEvent {
    data class IsShowDialog(val isShow: Boolean) : HomeEvent
    data class OnChangeTitulo(val titulo: String) : HomeEvent
    data class OnChangeValor(val valor: String) : HomeEvent
    data class OnChangeTipo(val tipo: TipoDespesa) : HomeEvent
    data class OnSave(val form: Int) : HomeEvent
    data class OnDelete(val id: Long) : HomeEvent
}