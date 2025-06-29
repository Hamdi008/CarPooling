@file:OptIn(ExperimentalMaterial3Api::class)

package com.hamdi.carpooling.features.dashboard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.hamdi.carpooling.core.navigation.LocalNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier
) {
    val navController = LocalNavController.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Dashboard",
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
                        colors = listOf(Color(0xFF4FACFE), Color(0xFF00F2FE))
                    )
                )
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopCenter),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "Welcome back, Hamdi!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DashboardCard(
                        title = "Active Rides",
                        count = 3,
                        icon = Icons.Default.Favorite,
                        modifier = Modifier.weight(1f).padding(8.dp),
                        onClick = { /* TODO: Navigate to Active Rides */ }
                    )
                    DashboardCard(
                        title = "Pending Requests",
                        count = 1,
                        icon = Icons.Default.Notifications,
                        modifier = Modifier.weight(1f).padding(8.dp),
                        onClick = { /* TODO: Navigate to Requests */ }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DashboardCard(
                        title = "Offer a Ride",
                        icon = Icons.Default.Person,
                        modifier = Modifier.weight(1f).padding(8.dp),
                        onClick = { /* TODO: Navigate to Offer a Ride */ }
                    )
                    DashboardCard(
                        title = "Find a Ride",
                        icon = Icons.Default.Menu,
                        modifier = Modifier.weight(1f).padding(8.dp),
                        onClick = { /* TODO: Navigate to Find a Ride */ }
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardCard(
    modifier: Modifier = Modifier,
    title: String,
    count: Int? = null,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier
            .height(140.dp)
            .clickable { onClick() },
        tonalElevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = Color.White.copy(alpha = 0.9f)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(icon, contentDescription = title, tint = Color(0xFF007AFF), modifier = Modifier.size(36.dp))
            Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
            count?.let {
                Text("$it", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDashboardScreen() {
    val fakeNavController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides fakeNavController) {
        DashboardScreen()
    }
}

