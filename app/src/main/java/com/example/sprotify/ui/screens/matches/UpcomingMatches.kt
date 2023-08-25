package com.example.sprotify.ui.screens.matches

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.sprotify.R
import com.example.sprotify.data.BottomNavigationScreens
import com.example.sprotify.ui.shared.components.BottomNavBar
import com.example.sprotify.ui.shared.components.LeagueCard
import com.example.sprotify.ui.theme.SprotifyTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatchesScreen() {

    val navController = rememberNavController()

    val items = listOf(
        BottomNavigationScreens.Dashboard,
        BottomNavigationScreens.Clip,
        BottomNavigationScreens.News,
        BottomNavigationScreens.User
    )

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = {
            BottomNavBar(items = items, navController = navController)
        }
    ) {
        paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)){
            LazyColumn() {
                item {
                    Header()
                    LazyRow() {
                        item {
                            LeagueCard()
                            LeagueCard()
                            LeagueCard()
                            LeagueCard()
                        }
                    }
                    Tabbed()
                }
            }
        }
    }
}


@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(text = "Matches", style = MaterialTheme.typography.titleLarge)
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )) {
            Text(text = "Football", style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            ))
        }
    }
}

@Composable
fun Tabbed() {

    var selectedIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        "Upcoming",
        "Past Matches"
    )
    TabRow(selectedTabIndex = selectedIndex, containerColor = Color.White, divider = {}) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
            )
        }

    }

    when (selectedIndex) {
        0 -> UpcomingMatches()
        1 -> PastMatches()
    }
}

@Composable
fun PastMatches() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "Friday - February 25")
        Spacer(modifier = Modifier.height(24.dp))
        PostMatchCard()
        PostMatchCard()
    }
}


@Composable
fun PostMatchCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(bottom = 24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(120.dp)
                .align(Alignment.TopStart)
                .background(Color(0xFFEEEDED))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "CHELSEA", style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF322D2D)
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.premire),
                    contentDescription = "Logo",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    "2", style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 28.sp,
                        color = Color(0xFF5B5757)
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(120.dp)
                .align(Alignment.TopEnd)
                .background(Color(0xFFE3E3E3))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "2",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 28.sp,
                        color = Color(0xFF5B5757)
                    )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    painter = painterResource(id = R.drawable.premire),
                    contentDescription = "Logo",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "MAN UTD", style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF322D2D)
                    )
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)
                .background(Color(0xFF1E1E1E))
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(4.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.premire),
                        contentDescription = "Premiere",
                        modifier = Modifier
                            .size(32.dp)
                            .aspectRatio(1f)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Premier League",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.White,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Text(
                            text = "Best of 3", style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.Gray,
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                    }
                    Icon(Icons.Filled.PlayArrow, contentDescription = "Play", tint = Color.White)
                }
            }
        }
    }
}


@Composable
fun UpcomingMatches() {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "Friday - February 25")
        Spacer(modifier = Modifier.height(24.dp))
        UpcomingMatchCard()
        UpcomingMatchCard()
        UpcomingMatchCard()
    }
}


@Composable
fun UpcomingMatchCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(191.dp)
            .padding(top = 16.dp)
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
                .align(Alignment.TopStart)
                .background(Color(0xFFEEEDED))
                .padding(16.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.premire), contentDescription = "Premiere")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "CHELSEA", style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF322D2D)
                    )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Image(painter = painterResource(id = R.drawable.chelsea), contentDescription = "Chelsea", modifier = Modifier.size(48.dp))
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
                .align(Alignment.TopEnd)
                .background(Color(0xFFE3E3E3))
                .padding(16.dp)
        ) {
            Text(text = "7 PM", style = MaterialTheme.typography.bodyMedium.copy(
                color = Color(0xFF5B5757),
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            ), modifier = Modifier
                .align(Alignment.TopEnd)
                .alpha(0.5f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.chelsea), contentDescription = "Chelsea", modifier = Modifier.size(48.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "CHELSEA", style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF322D2D)
                    )
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .align(Alignment.BottomCenter)
                .background(Color(0xFF1E1E1E))
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "PLAYOFFS-ROUND 1",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = "Best of 3", style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showUpcomingMatch() {
    SprotifyTheme {
        MatchesScreen()
    }
}
