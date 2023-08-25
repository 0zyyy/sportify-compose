package com.example.sprotify.ui.screens.highlights

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R
import com.example.sprotify.ui.shared.components.LeagueCard
import com.example.sprotify.ui.shared.components.SectionTitle
import com.example.sprotify.ui.theme.Brown80
import com.example.sprotify.ui.theme.Red40
import com.example.sprotify.ui.theme.SprotifyTheme

@Composable
fun HighlightScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Header()
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(4) {
                    LeagueCard()
                }
            }
            WatchLiveCard()
            SectionTitle(title = "FEATURED MATCH")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .background(Red40)
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
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "FIFA WORLD \nCUP DAILY",
                            style = MaterialTheme.typography.headlineMedium.copy(
                                color = Color.White,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                        )
                        Text(
                            text = "Watch match highlights",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                            )
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            shape = RectangleShape,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Brown80
                            )
                        ) {
                            Text(text = "Play", color = Color.White)
                        }
                    }
                }
            }
            SectionTitle(title = "POPULAR MATCH")
            GrodCard()
        }
    }
}


@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Highlights", style = MaterialTheme.typography.titleLarge)
        Button(
            onClick = { /*TODO*/ }, shape = RectangleShape, colors = ButtonDefaults.buttonColors(
                containerColor = Red40
            )
        ) {
            Text(text = "Football", color = Color.White)
        }
    }
}


@Composable
fun WatchLiveCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.orang),
                contentDescription = "Watch live Now",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(208.dp)
            )

            Text(
                text = "keep an eye on the stadium",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(start = 4.dp, top = 12.dp, end = 4.dp)
            )
            Text(
                text = "Watch sports live or highlights, read every news from your smartphone",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black
                ),
                modifier = Modifier.padding(start = 4.dp, top = 4.dp, end = 4.dp)
            )
        }
    }
}

@Composable
fun GrodCard(){
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
}

@Preview(showBackground = true)
@Composable
fun HighlightScreenPreview() {
    SprotifyTheme {
        HighlightScreen()
    }
}