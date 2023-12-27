package com.ricky.meudindin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.lifecycleScope
import com.ricky.meudindin.common.DataStoreUtil
import com.ricky.meudindin.navigation.AppNav
import com.ricky.meudindin.ui.theme.MeuDinDInTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var dataStore: DataStoreUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataStore = DataStoreUtil(applicationContext)
        var darkMode by mutableStateOf(false)

        lifecycleScope.launch {
            dataStore.getTheme().collect {
                darkMode = it
            }
        }
        setContent {
            MeuDinDInTheme(darkTheme = darkMode) {
                AppNav()
            }
        }
    }
}

