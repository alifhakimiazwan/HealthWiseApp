package com.example.wellnessapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellnessapp.ui.themeTheme.kt.WellnessappTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit, // Lambda to handle login click with username and password
    modifier: Modifier = Modifier
) {
    // Declare mutable state variables for username and password
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // App name
        Text(
            text = "HealthWise",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            fontSize = 60.sp,
            modifier = Modifier.padding(bottom = 32.dp) // Space below app name
        )

        // Username input
        OutlinedTextField(
            value = username.value, // Use .value to access the state
            onValueChange = { username.value = it }, // Set value with .value
            textStyle = MaterialTheme.typography.bodySmall,
            label = { Text("Username") },

            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true
        )

        // Password input
        OutlinedTextField(
            value = password.value, // Use .value to access the state
            onValueChange = { password.value = it }, // Set value with .value
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            visualTransformation = PasswordVisualTransformation(), // Hides password characters
            singleLine = true
        )

        Button(
            onClick = { onLoginClick(username.value, password.value) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                disabledContainerColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.primary,
                disabledContentColor = MaterialTheme.colorScheme.onPrimary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            enabled = username.value.isNotBlank() && password.value.isNotBlank()
        ) {
            Text("Log In")
        }
        Text(
            text = "Don't have an account? ",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline, // Set to a readable color
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = "Sign up here",
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary, // Set to primary color for the link effect
            modifier = Modifier
                .clickable { } // Handle click to navigate to sign up
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    WellnessappTheme(){
        LoginScreen(
            onLoginClick = { username, password ->
                println("Username: $username, Password: $password")
            }
        )
    }
}