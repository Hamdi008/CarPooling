package com.hamdi.carpooling.features.welcome.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hamdi.carpooling.core.navigation.LocalNavController
import com.hamdi.carpooling.core.navigation.Routes.SIGN_UP
import com.hamdi.carpooling.features.welcome.presentation.WelcomeViewModel

@Composable
fun WelcomeScreen(modifier: Modifier, viewModel: WelcomeViewModel = hiltViewModel()) {
    val navController = LocalNavController.current
    val msg = viewModel.welcomeMessage.value

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFF4FACFE), Color(0xFF00F2FE))
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Text(
                text = "Welcome to CarPooling!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = msg,
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.9f)
            )

            Button(
                onClick = {
                    navController.navigate(SIGN_UP)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Get Started",
                    color = Color(0xFF007AFF),
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen(modifier = Modifier, viewModel = hiltViewModel())
}