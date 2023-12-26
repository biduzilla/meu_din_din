package com.ricky.meudindin.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricky.meudindin.common.DataStoreUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataStoreUtil: DataStoreUtil) : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        recuperaTema()
    }

    private fun recuperaTema() {
        viewModelScope.launch {
            dataStoreUtil.getTheme().collect { isDark ->
                _state.update {
                    it.copy(isDark = isDark)
                }
            }
        }
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.OnChangeTheme -> {
                viewModelScope.launch {
                    dataStoreUtil.saveTheme(event.isDark)
                }
            }
        }
    }
}