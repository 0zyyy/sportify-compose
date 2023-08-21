package com.example.sprotify.ui.screens.auth.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    label: String,
    modifier: Modifier = Modifier
) {
    var input by remember { mutableStateOf("") }

    TextField(
        label = { Text(label) },
        value = input,
        onValueChange = {
            input = it
        },
        modifier = modifier,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFFF4F4F4),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
    )
}