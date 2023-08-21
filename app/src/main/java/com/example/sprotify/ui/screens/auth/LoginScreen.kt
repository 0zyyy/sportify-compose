package com.example.sprotify.ui.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sprotify.ui.screens.auth.components.Header
import com.example.sprotify.ui.screens.auth.components.InputField
import com.example.sprotify.ui.theme.SprotifyTheme

@Composable
fun LoginScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Header(title = "SIGN IN WITH YOUR SPORTIFY ID", text = "SIGN IN")
            InputField(
                label = "Email", modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            InputField(
                label = "Password", modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            ) {
                Text(text = "SIGN IN")
            }

            Text(
                text = "Your Sportify account is now Sportify ID. If you’ve signed into the app before, use the same credentials here. otherwise",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
                contentAlignment = Alignment.Center) {
                Text(
                    text = "OR",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    ),
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                )
            ) {
                Text(text = "SIGN UP")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showLoginScreen() {
    SprotifyTheme {
        LoginScreen()
    }
}