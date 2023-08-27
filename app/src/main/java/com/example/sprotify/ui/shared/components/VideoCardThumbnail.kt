package com.example.sprotify.ui.shared.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R

@Composable
fun VideoCardThubmnail(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .background(color = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.orang),
                contentDescription = "Logo Red",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(171.dp)
                    .height(132.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Qatar World Cup 2022",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF322D2D)
                )
            )
            Text(
                text = "Best of Portugal goals against Switzerland",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(8.dp)
            )
        }

        Button(onClick = { /*TODO*/ },
            shape = CutCornerShape(15.dp),
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = 10.dp)
                .size(width = 50.dp, height = 20.dp)
        ) {
            Text(text = "IYH")
        }
    }
}