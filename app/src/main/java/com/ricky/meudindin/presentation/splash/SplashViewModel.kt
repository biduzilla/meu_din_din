package com.ricky.meudindin.presentation.splash

import android.os.Handler
import android.os.Looper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() {
    private val _state = MutableStateFlow(SplashState())
    val state = _state.asStateFlow()

    init {
        tempoEspera()
    }

    private fun tempoEspera() {
        Handler(Looper.getMainLooper()).postDelayed({
            _state.value = _state.value.copy(
                isLoading = true
            )
        }, 2000)
    }
}