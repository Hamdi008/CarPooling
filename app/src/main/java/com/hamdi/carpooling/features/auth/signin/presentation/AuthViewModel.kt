package com.hamdi.carpooling.features.auth.signin.presentation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.features.auth.signin.data.model.LoginRequest
import com.hamdi.carpooling.features.auth.signin.domain.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            Log.d("HEL:", "AuthViewModel init")

            authRepository.login(LoginRequest(username = "test1", password = "test1"))

            authRepository.getProfile()
        }
    }
}