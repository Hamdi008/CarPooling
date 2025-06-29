@file:OptIn(ExperimentalMaterial3Api::class)

package com.hamdi.carpooling.features.settings.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.hamdi.carpooling.core.navigation.LocalNavController

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
) {
    val navController = LocalNavController.current

    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(false) }
    var privacyModeEnabled by remember { mutableStateOf(false) }
    var autoUpdateEnabled by remember { mutableStateOf(true) }
    var selectedLanguage by remember { mutableStateOf("English") }
    var showLanguageDialog by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    val languages = listOf("English", "French", "Arabic")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Settings",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
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
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Preferences",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                // Notifications toggle
                SettingSwitchItem(
                    label = "Enable Notifications",
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it }
                )

                // Dark mode toggle
                SettingSwitchItem(
                    label = "Dark Mode",
                    checked = darkModeEnabled,
                    onCheckedChange = { darkModeEnabled = it }
                )

                // Privacy mode toggle
                SettingSwitchItem(
                    label = "Privacy Mode",
                    checked = privacyModeEnabled,
                    onCheckedChange = { privacyModeEnabled = it }
                )

                // Auto-update toggle
                SettingSwitchItem(
                    label = "Auto Update",
                    checked = autoUpdateEnabled,
                    onCheckedChange = { autoUpdateEnabled = it }
                )

                // Language selector label
                Text(
                    "Select Language",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )

                // Show selected language in a clickable row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showLanguageDialog = true }
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(selectedLanguage, color = Color.White, fontSize = 16.sp)
                    Icon(
                        imageVector = Icons.Default.ArrowBack, // You might want to replace with a dropdown arrow icon
                        contentDescription = "Select Language",
                        tint = Color.White,
                        modifier = Modifier.rotate(270f) // rotate arrow to point down
                    )
                }

                // Language selection dialog
                if (showLanguageDialog) {
                    AlertDialog(
                        onDismissRequest = { showLanguageDialog = false },
                        title = {
                            Text(text = "Select Language")
                        },
                        text = {
                            Column {
                                languages.forEach { language ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                selectedLanguage = language
                                                showLanguageDialog = false
                                            }
                                            .padding(vertical = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(
                                            selected = selectedLanguage == language,
                                            onClick = {
                                                selectedLanguage = language
                                                showLanguageDialog = false
                                            },
                                            colors = RadioButtonDefaults.colors(selectedColor = MaterialTheme.colorScheme.primary)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(language, fontSize = 16.sp)
                                    }
                                }
                            }
                        },
                        confirmButton = {
                            TextButton(onClick = { showLanguageDialog = false }) {
                                Text("Cancel")
                            }
                        }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Clear Cache button
                TextButton(
                    onClick = { /* TODO: Clear Cache Logic */ },
                    //modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Clear Cache",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }

                // About App section
                Text(
                    "About",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
                )

                Text(
                    "App Version: 1.0.0",
                    color = Color.White,
                    fontSize = 14.sp
                )

                Text(
                    "Terms of Service",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { /* TODO: Navigate to Terms */ }
                        .padding(vertical = 4.dp)
                )

                Text(
                    "Privacy Policy",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .clickable { /* TODO: Navigate to Privacy */ }
                        .padding(vertical = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun SettingSwitchItem(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!checked) }
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color.White, fontSize = 16.sp)
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(checkedThumbColor = Color.White)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSettingsScreen() {
    val fakeNavController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides fakeNavController) {
        SettingsScreen()
    }
}
