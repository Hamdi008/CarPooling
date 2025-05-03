package com.hamdi.carpooling.features.auth.signup.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamdi.carpooling.features.auth.signup.data.model.RegisterRequest
import com.hamdi.carpooling.features.auth.signup.domain.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerRepository: RegisterRepository
) : ViewModel() {


    fun registerUser(
        name: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {

        viewModelScope.launch {
            try {
                val response = registerRepository.register(
                    RegisterRequest(
                        username = name,
                        email = email,
                        password = password
                    )
                )
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    onError(errorMessage)
                }
            } catch (e: Exception) {
                onError(e.message ?: "Unexpected error")
            }
        }
    }
}