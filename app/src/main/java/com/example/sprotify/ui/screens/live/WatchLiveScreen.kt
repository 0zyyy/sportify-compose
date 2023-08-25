package com.example.sprotify.ui.screens.live

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R
import com.example.sprotify.ui.screens.highlights.WatchLiveCard
import com.example.sprotify.ui.shared.components.SectionTitle
import com.example.sprotify.ui.theme.SprotifyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchLiveScreen() {
    LazyColumn(

    ) {
        item {
            ThumbnailCard()
            SectionTitle("FEATURED MATCH")
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .height(525.dp)
                    .padding(16.dp)
            ) {
                items(4) {
                    Box(
                        modifier = Modifier
                            .width(180.dp)
                            .padding(vertical = 8.dp, horizontal = 16.dp)
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
                    }
                }
            }
            SectionTitle(title = "Featured Match")
            WatchLiveCard()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showWatchLiveScreen() {
    SprotifyTheme {
        WatchLiveScreen()
    }
}

@Composable
fun ThumbnailCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 24.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Image(
                painter = painterResource(id = R.drawable.orang),
                contentDescription = "Watch live Now",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(208.dp)
            )

            Text(
                text = "keep an eye on the stadium |Round of 16 | Fifa World Cup Qatar",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(start = 4.dp, top = 12.dp, end = 4.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Tanggal
            Row {
                Text(text = "Dec 12, 2021,", style = MaterialTheme.typography.bodySmall)
                Text(text = " 2 Min", style = MaterialTheme.typography.bodySmall)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Watch sports live or highlights, read every news from your smartphone. Al Rayyan on Tuesday,  at education city stadium. FIFA world cup qatar",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp)
            )
        }
    }
}