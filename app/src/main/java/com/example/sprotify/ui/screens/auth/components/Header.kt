package com.example.sprotify.ui.screens.auth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R

@Composable
fun Header(
    title: String,
    subtitle: String = "",
    text: String = "JOIN"
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(246.dp)
            .background(color = Color(0xFFFF5050))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .width(140.dp)
                .height(24.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
        ) {
            Column {
                Text(
                    title, style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                if (subtitle.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        subtitle,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
        Text(
            text,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(20.dp, 20.dp),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 110.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 5.sp,
                color = Color(0x11FFFFFF)
            ),
        )
    }
}