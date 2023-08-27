package com.example.sprotify.ui.screens.matches.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R
import com.example.sprotify.ui.theme.Brown80


@Composable
fun ReadMoreCard(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .background(color = Color(0xFF000000).copy(alpha = 0.5f))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.orang),
                    contentDescription = "Featured Match",
                    contentScale = ContentScale.Crop
                )

            }

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "Qatar World Cup 2022",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontSize = 12.sp,
                    )
                )
                Text(
                    text = "Messi goals against Switzerland",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Button(
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Brown80
                    )
                ) {
                    Text(
                        text = "Read More", style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        ), color = Color.White
                    )
                }
            }
        }
    }
}