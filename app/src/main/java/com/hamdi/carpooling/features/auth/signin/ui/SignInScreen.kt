package com.hamdi.carpooling.features.auth.signin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.hamdi.carpooling.core.navigation.LocalNavController
import com.hamdi.carpooling.core.navigation.Routes.HOME
import com.hamdi.carpooling.core.navigation.Routes.SIGN_UP
import com.hamdi.carpooling.features.auth.signin.presentation.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(viewModel: AuthViewModel? = hiltViewModel() ) {

    val navController = LocalNavController.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    val gradient = Brush.verticalGradient(
        listOf(Color(0xFF4FACFE), Color(0xFF00F2FE))
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp))
            {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Welcome Back",
                        style = MaterialTheme.typography.headlineMedium,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Sign in to continue",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.Transparent,
                            cursorColor = Color.White,
                            focusedBorderColor = Color.White.copy(alpha = 0.8f),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.4f),
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White.copy(alpha = 0.6f)
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        leadingIcon = {
                            Icon(
                                Icons.Default.Email,
                                contentDescription = "Email",
                                tint = Color.White.copy(alpha = 0.8f)
                            )
                        }
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.Transparent,
                            cursorColor = Color.White,
                            focusedBorderColor = Color.White.copy(alpha = 0.8f),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.4f),
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White.copy(alpha = 0.6f)
                        ),
                        visualTransformation = if (passwordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    imageVector = if (passwordVisible) Icons.Default.Visibility
                                    else Icons.Default.VisibilityOff,
                                    contentDescription = if (passwordVisible) "Hide password"
                                    else "Show password",
                                    tint = Color.White.copy(alpha = 0.8f)
                                )
                            }
                        }
                    )
                }

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = {
                            viewModel?.login(
                                email = email,
                                password = password,
                                onSuccess = {
                                    navController.navigate(HOME)
                                },
                                onError = { error ->
                                }
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color(0xFF005BEA)
                        )
                    ) {
                        Text("Sign In", fontWeight = FontWeight.SemiBold)
                    }

                    TextButton(
                        onClick = { navController.navigate(SIGN_UP) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "Don't have an account? Sign Up",
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignIn() {
    val fakeNavController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides fakeNavController) {
        SignInScreen(viewModel = null)
    }
}