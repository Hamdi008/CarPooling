package com.hamdi.carpooling.features.auth.pin.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.features.auth.pin.domain.PinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PinViewModel @Inject constructor(
    private val pinRepository: PinRepository
) : ViewModel() {

    var phoneNumber  = mutableStateOf("")

    fun sendPin(phoneNumber: String) {
        viewModelScope.launch {

        }
    }

    fun verifyPin(phoneNumber: String, pin: String) {
        viewModelScope.launch {

        }
    }
}