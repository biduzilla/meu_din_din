package com.ricky.meudindin.presentation.main

sealed interface MainEvent {
    data class OnChangeTheme(val isDark: Boolean) : MainEvent
}