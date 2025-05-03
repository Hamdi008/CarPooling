package com.hamdi.carpooling.features.welcome.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.features.welcome.domain.WelcomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val welcomeRepository: WelcomeRepository
) : ViewModel() {

    var welcomeMessage = mutableStateOf("Loading...")
        private set

    init {
        viewModelScope.launch {
            welcomeMessage.value = welcomeRepository.getWelcomeData()
        }
    }
}