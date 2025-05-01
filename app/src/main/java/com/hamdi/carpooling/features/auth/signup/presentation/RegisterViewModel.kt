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

        Log.d("HEL:"," data from SignUp Screen: name = $name ; email = $email ; password = $password")
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
                    Log.d(
                        "HEL:",
                        "Registration successful: ${response.body()?.message}"
                    )
                    onSuccess()
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown error"
                    Log.e("HEL:", "Registration failed: $errorMessage")
                    onError(errorMessage)
                }
            } catch (e: Exception) {
                Log.e("HEL:", "Exception: ${e.message}")
                onError(e.message ?: "Unexpected error")
            }
        }
    }
}