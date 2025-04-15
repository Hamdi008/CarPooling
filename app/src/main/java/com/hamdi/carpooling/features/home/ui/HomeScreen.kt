package com.hamdi.carpooling.features.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(modifier: Modifier) {
    Column() {
        Text(text = "Welcome to Home Screen!", modifier = modifier.padding(bottom = 16.dp))
        Button(onClick = {
            // You can add navigation actions here if needed
            // For now, just displaying a simple button
        }) {
            Text("Go to next screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    //HomeScreen(navController = NavController(context = null))  // Preview doesn't require real NavController
}