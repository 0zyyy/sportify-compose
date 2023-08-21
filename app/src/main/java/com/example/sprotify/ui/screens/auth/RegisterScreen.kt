package com.example.sprotify.ui.screens.auth

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.ui.screens.auth.components.Header
import com.example.sprotify.ui.screens.auth.components.InputField
import com.example.sprotify.ui.theme.SprotifyTheme


@Composable
fun RegisterScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item{
            Header(title = "Create your sportify id", subtitle = "Get news,game updates highlights and more info on your favorite teams")
            InputField(
                label = "First Name", modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            InputField(
                label = "Last Name", modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()
            )
            InputField(
                label = "Email", modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()
            )
            InputField(
                label = "Password", modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .fillMaxWidth()
            )
            Text(
                "Password must be at least 8 character long and include 1 capital letter and 1 symbol",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var checked by remember {
                    mutableStateOf(false)
                }
                Checkbox(checked = checked, onCheckedChange = {
                    // TODO: onCheckedChange
                    checked = !checked
                })
                Text(
                    "I agree to the Terms and Privacy Policy",
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 14.sp
                    )
                )
            }
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
                Text(text = "CREATE ACCOUNT")
            }
            Text(
                text = "By agreeing to the above terms, you are consenting that your personal information will be collected, stored, and processed in the United States and the European Union on behalf of Sporify Properties, Inc.",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    SprotifyTheme {
        RegisterScreen()
    }
}