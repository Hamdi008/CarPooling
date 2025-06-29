@file:OptIn(ExperimentalMaterial3Api::class)

package com.hamdi.carpooling.features.notifications.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
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

data class NotificationItem(val title: String, val message: String)

@Composable
fun NotificationsScreen(
    modifier: Modifier = Modifier,
    // TODO: Create dynamic notifications list
    notifications: List<NotificationItem> = listOf(
        NotificationItem("New Ride Request", "You have a new ride request from John."),
        NotificationItem("Ride Cancelled", "Your ride to Sfax has been cancelled."),
        NotificationItem("Payment Received", "You’ve received payment for your last trip.")
    )
) {
    val navController = LocalNavController.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Notifications",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
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
                .padding(16.dp)
        ) {
            if (notifications.isEmpty()) {
                Text(
                    text = "No notifications available.",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(notifications) { notification ->
                        NotificationCard(notification)
                    }
                }
            }
        }
    }
}

@Composable
fun NotificationCard(notification: NotificationItem) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        tonalElevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        color = Color.White.copy(alpha = 0.95f)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = notification.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF007AFF)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = notification.message,
                fontSize = 14.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewNotificationsScreen() {
    val fakeNavController = rememberNavController()

    CompositionLocalProvider(LocalNavController provides fakeNavController) {
        NotificationsScreen(
            notifications = listOf(
                NotificationItem("New Ride Request", "You have a new ride request from John."),
                NotificationItem("Ride Cancelled", "Your ride to Sfax has been cancelled."),
                NotificationItem("Payment Received", "You’ve received payment for your last trip.")
            )
        )
    }
}

