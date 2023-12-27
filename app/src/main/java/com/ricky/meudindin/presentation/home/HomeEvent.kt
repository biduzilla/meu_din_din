package com.ricky.meudindin.presentation.home

sealed interface HomeEvent {
    data class IsShowDialog(val isShow: Boolean) : HomeEvent
}