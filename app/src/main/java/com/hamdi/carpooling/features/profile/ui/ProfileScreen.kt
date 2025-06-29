@file:OptIn(ExperimentalMaterial3Api::class)

package com.hamdi.carpooling.features.profile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.hamdi.carpooling.core.navigation.LocalNavController

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    val navController = LocalNavController.current

    // TODO: create state under Profile viewModel
    var name by remember { mutableStateOf(TextFieldValue("Hamdi Elfekih")) }
    var email by remember { mutableStateOf(TextFieldValue("hamdi@example.com")) }
    var phone by remember { mutableStateOf(TextFieldValue("+216 99 999 999")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Profile",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF007AFF)
                )
            )
        },
        containerColor = Color.Transparent
    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF4FACFE), Color(0xFF00F2FE))
                    )
                )
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Your Profile",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                ProfileTextField(label = "Full Name", value = name) { name = it }
                ProfileTextField(label = "Email Address", value = email) { email = it }
                ProfileTextField(label = "Phone Number", value = phone) { phone = it }

                Button(
                    onClick = { /* TODO: Save changes */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit", tint = Color(0xFF007AFF))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Save Changes", color = Color(0xFF007AFF), fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

@Composable
fun ProfileTextField(
    label: String,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White.copy(alpha = 0.6f),
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White.copy(alpha = 0.7f),
            cursorColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfileScreen() {
    val fakeNavController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides fakeNavController) {
        ProfileScreen()
    }
}

