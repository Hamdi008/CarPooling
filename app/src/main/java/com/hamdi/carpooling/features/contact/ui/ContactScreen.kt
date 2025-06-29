@file:OptIn(ExperimentalMaterial3Api::class)

package com.hamdi.carpooling.features.contact.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hamdi.carpooling.core.navigation.LocalNavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ContactScreen(modifier: Modifier = Modifier,) {
    val navController = LocalNavController.current

    var name by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var message by remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Contact Us",
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
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF4FACFE), Color(0xFF00F2FE))
                    )
                )
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "We'd love to hear from you!",
                    fontSize = 22.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Your Name") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.Transparent,
                        cursorColor = Color.White,
                        focusedBorderColor = Color.White.copy(alpha = 0.8f),
                        unfocusedBorderColor = Color.White.copy(alpha = 0.4f),
                        focusedLabelColor = Color.White,
                        unfocusedLabelColor = Color.White.copy(alpha = 0.6f)
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Name",
                            tint = Color.White.copy(alpha = 0.8f)
                        )
                    }
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email Address") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
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

                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.padding(bottom = 4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.TextFields,
                            contentDescription = "Message",
                            tint = Color.White.copy(alpha = 0.8f),
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Message",
                            color = Color.White.copy(alpha = 0.8f),
                            style = MaterialTheme.typography.labelLarge
                        )
                    }

                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        maxLines = 5,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.Transparent,
                            cursorColor = Color.White,
                            focusedBorderColor = Color.White.copy(alpha = 0.8f),
                            unfocusedBorderColor = Color.White.copy(alpha = 0.4f)
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                }


                Button(
                    onClick = {
                        // TODO: Handle submit
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Send Message", color = Color(0xFF007AFF))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
    val fakeNavController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides fakeNavController) {
        ContactScreen()
    }
}



