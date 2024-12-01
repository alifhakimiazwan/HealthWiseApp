package com.example.wellnessapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WellnessBottomAppBar() {
    Surface(
        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
        color = Color(0xFFFFFFFF), // Background color for the bar
        shadowElevation = 30.dp
    ) {
        BottomAppBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            // Make BottomAppBar transparent to show Surface color
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                // Home Icon and Label
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    IconButton(onClick = { /* TODO: Navigate to home */ }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(40.dp)
                        )
                    }
//                    Text(
//                        text = "Home",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.bodySmall,
//                        modifier = Modifier
//                            .padding(top = 0.dp)
//                    )
                }

                // Add Icon and Label
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { /* TODO: Add new item */ }) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "Add",
                            tint = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.size(40.dp)
                        )
                    }
//                    Text(
//                        text = "Add",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.bodySmall,
//                        modifier = Modifier.padding(top = 2.dp)
//                    )
                }

                // Profile Icon and Label
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { /* TODO: Go to profile */ }) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.size(40.dp)
                        )
                    }
//                    Text(
//                        text = "Profile",
//                        color = MaterialTheme.colorScheme.primary,
//                        style = MaterialTheme.typography.bodySmall,
//                        modifier = Modifier.padding(top = 2.dp)
//                    )
                }
            }
        }
    }
}