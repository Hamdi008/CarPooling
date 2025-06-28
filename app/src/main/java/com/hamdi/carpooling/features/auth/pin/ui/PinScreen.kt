@file:OptIn(ExperimentalMaterial3Api::class)

package com.hamdi.carpooling.features.auth.pin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hamdi.carpooling.core.theme.CarPoolingTheme
import com.hamdi.carpooling.features.auth.pin.presentation.PinViewModel
import com.hamdi.carpooling.utils.ResultState
import kotlinx.coroutines.delay

@Composable
fun PinScreen(modifier: Modifier = Modifier, phoneNumber: String, viewModel: PinViewModel = hiltViewModel()) {
    val pinLength = 6
    var pin by remember { mutableStateOf("") }
    // Collect states from ViewModel
    val sendPinState by viewModel.sendPinState
    val verifyPinState by viewModel.verifyPinState

    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF4FACFE), Color(0xFF00F2FE))
    )

    var isResendEnabled by remember { mutableStateOf(false) }
    var secondsLeft by remember { mutableStateOf(60) }
    var resendRequested by remember { mutableStateOf(true) }

    LaunchedEffect(resendRequested) {
        if (resendRequested) {
            isResendEnabled = false
            secondsLeft = 60
            for (i in 60 downTo 1) {
                delay(1000)
                secondsLeft = i - 1
            }
            isResendEnabled = true
            resendRequested = false
        }
    }

    LaunchedEffect(sendPinState) {
        when (sendPinState) {
            is ResultState.Success -> {
                // PIN resend success - maybe show confirmation
            }
            is ResultState.Error -> {
                // Show error message to user
            }
            ResultState.Loading -> {
                // Could show loading indicator if you want
            }
            else -> {}
        }
    }

    LaunchedEffect(verifyPinState) {
        when (verifyPinState) {
            is ResultState.Success -> {
                // PIN verified successfully - navigate forward
            }
            is ResultState.Error -> {
                // Show error message to user
            }
            ResultState.Loading -> {
                // Show loading if desired
            }
            else -> {}
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradient)
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Text(
                text = "Enter PIN",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = pin,
                onValueChange = {
                    if (it.length <= pinLength && it.all { ch -> ch.isDigit() }) pin = it
                },
                label = { Text("6-digit PIN") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.Transparent,
                    cursorColor = Color.White,
                    focusedBorderColor = Color.White.copy(alpha = 0.8f),
                    unfocusedBorderColor = Color.White.copy(alpha = 0.4f),
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White.copy(alpha = 0.6f)
                )
            )

            Button(
                onClick = {
                    if (pin.length == pinLength) viewModel.verifyPin(phoneNumber, pin)
                },
                enabled = pin.length == pinLength,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF005BEA)
                )
            ) {
                Text("Confirm", fontWeight = FontWeight.SemiBold)
            }

            TextButton(
                onClick = {
                    if (isResendEnabled) {
                        resendRequested = true
                        // TODO: Call your actual resend logic here
                    }
                },
                enabled = isResendEnabled,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                val text = if (isResendEnabled) {
                    "Didn't receive a PIN? Resend SMS"
                } else {
                    "You can resend in $secondsLeft s"
                }

                Text(
                    text = text,
                    color = Color.White.copy(alpha = if (isResendEnabled) 0.9f else 0.5f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPinScreen() {
    CarPoolingTheme {
        PinScreen(phoneNumber = "")
    }
}
