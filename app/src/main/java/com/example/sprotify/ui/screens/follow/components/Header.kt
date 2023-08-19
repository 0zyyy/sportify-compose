package com.example.sprotify.ui.screens.follow.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    title: String,
    subtitleText: String
){
    Box(
        modifier = Modifier
            .offset(x = 0.dp, y = 0.dp)
            .fillMaxWidth()
            .height(273.dp)
            .background(color = Color(0xFFFF5050))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Arrow Back", tint = Color.White)
            Column {
                Text(title, style = MaterialTheme.typography.headlineMedium)
                Text(subtitleText,style = MaterialTheme.typography.bodyMedium)
            }
        }

        Text("FOLLOWS", textAlign = TextAlign.Justify, modifier = Modifier.align(Alignment.CenterEnd).offset(30.dp,20.dp), style = MaterialTheme.typography.headlineMedium.copy(
            fontSize = 110.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 5.sp,
            color = Color(0x11FFFFFF)
        ))
    }
}