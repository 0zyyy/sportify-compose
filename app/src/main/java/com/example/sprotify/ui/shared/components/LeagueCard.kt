package com.example.sprotify.ui.shared.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun LeagueCard() {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .background(color = Color(0xFFEEEDED))
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.premire),
                    contentDescription = "Premiere League Logo",
                    modifier = Modifier
                        .size(48.dp)
                        .aspectRatio(1f)
                )
            }
            Text(
                "Premiere \nLeague",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold

                )
            )
        }
    }
}