package com.ricky.meudindin.presentation.historico

sealed interface HistoricoEvent {
    data class OnChangeFiltro(val dias: Int) : HistoricoEvent
}