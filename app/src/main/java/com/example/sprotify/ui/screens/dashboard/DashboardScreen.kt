package com.example.sprotify.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
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
import com.example.sprotify.ui.theme.SprotifyTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Header()
            SearchBar()
            val list = listOf(
                "Trending", "Football", "Basketball", "Cricket"
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                items(list.size, itemContent = { item ->
                    Chip(name = list[item])
                })
            }
            DashboardHero()
            SectionTitle(title = "FIFA WORLD CUP")
            HighlightCard()
            SectionTitle(title = "ALL LEAGUES")
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(4) {
                    LeagueCard()
                }
            }
            SectionTitle(title = "FEATURED MATCHES")
            GridCard()
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//                    .height(128.dp)
            .padding(start = 16.dp, end = 16.dp, top = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.width(140.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logo_red),
                contentDescription = "Logo Red",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(140.dp)
                    .height(50.dp)
            )
        }
        Icon(
            Icons.Rounded.Home, contentDescription = "Home", modifier = Modifier
                .size(24.dp)
                .aspectRatio(1f)
        )
    }
}

@Composable
fun Chip(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
) {
    Surface(
        modifier = Modifier
            .padding(end = 8.dp)
            .height(35.dp)
            .width(108.dp),
        tonalElevation = 8.dp,
        shape = RectangleShape,
        color = Brown80
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var text by remember {
        mutableStateOf("")
    }

    TextField(
        value = text, onValueChange = {
            text = it
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        label = {
            Text("Teams, sports or venue")
        },
        leadingIcon = {
            Icon(
                Icons.Filled.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .size(24.dp)
                    .aspectRatio(1f)
            )
        },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            placeholderColor = Color.Gray,
            cursorColor = Color.Gray,
            textColor = Color.Gray
        )
    )
}

@Composable
fun DashboardHero() {
    val contrast = 0.5f
    val colorMatrix = floatArrayOf(
        contrast, 0f, 0f, 0f, 0f,
        0f, contrast, 0f, 0f, 0f,
        0f, 0f, contrast, 0f, 0f,
        0f, 0f, 0f, 1f, 0f
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .background(Color.Red)
    ) {
        Image(
            painter = painterResource(id = R.drawable.orang),
            contentDescription = "Logo Red",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix(colorMatrix)),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "\uD83D\uDD25")
                    Text(
                        text = "Top News", style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "PHEONIX SUNS VS BOSTON CELTICS",
                style = MaterialTheme.typography.headlineLarge
            )
            Row {
                Text(
                    text = "Basketball", style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Red
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Wed 12.16", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "8.00 PM", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
fun HighlightCard() {
    // TODO: 20/08/2023 Gantien dadi seng bener
    //
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(135.dp)
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.orang),
                contentDescription = "Logo Red",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(160.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Box(
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .padding(vertical = 2.dp, horizontal = 8.dp)
                ) {
                    Text(
                        text = "Highlight", style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 10.sp,
                            color = Color.Black
                        )
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Portugal vs Spain",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 18.sp
                    ),
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Watch the highlights from the match between...",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 10.sp,
                        color = Color.Gray
                    )
                )
            }
        }
    }
}


@Composable
fun GridCard() {
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
fun DashboardPreview() {
    SprotifyTheme {
        DashboardScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun Grid() {
    SprotifyTheme {
        GridCard()
    }
}