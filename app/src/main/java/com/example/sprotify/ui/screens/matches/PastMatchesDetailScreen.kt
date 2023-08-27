package com.example.sprotify.ui.screens.matches

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R
import com.example.sprotify.ui.screens.matches.components.ReadMoreCard
import com.example.sprotify.ui.shared.components.GridCards
import com.example.sprotify.ui.shared.components.SectionTitle
import com.example.sprotify.ui.theme.SprotifyTheme


@Composable
fun PastMatchesDetailScreen() {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
    ) {
        item {
            BackButton()
            Hero()
            Tabbbed()
        }
    }
}


@Composable
fun BackButton() {
    Row {
        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
    }
}

@Composable
fun Hero() {
    Column {
        Text(text = "FINAL")
        Text(text = "20:00•18 Dec 2022")
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Team Logo
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chelsea),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(48.dp)
                        .aspectRatio(1f)
                )
                Text(text = "CHELSEA")
            }
            // Score
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "(4) 3 - 3 (2)"
                )
                Text(text = "Chelsea win 4-2 penalties")
                Text(text = "FULL-Time")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chelsea),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(48.dp)
                        .aspectRatio(1f)
                )
                Text(text = "CHELSEA")
            }
        }
    }
}

@Composable
fun Tabbbed() {

    var selectedIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        "Overview",
        "Stats",
        "Playing XI",
        "Videos",
    )
    TabRow(selectedTabIndex = selectedIndex, containerColor = Color.White, divider = {}) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title, fontSize = 14.sp) },
                selected = selectedIndex == index,
                onClick = { selectedIndex = index },
            )
        }

    }

    when (selectedIndex) {
        0 -> OverviewFragment()
        1 -> StatsFragment()
        2 -> PlayersFragment()
        3 -> VideosFragment()
    }
}

@Composable
fun OverviewFragment() {
    Column {
        SectionTitle(
            title = "FIFA WORLD CUP",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        ReadMoreCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(127.dp)
                .background(MaterialTheme.colorScheme.primary)
        )

        GridCards(
            modifier = Modifier
                .height(525.dp)
                .padding(top = 8.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun StatsFragment() {
    Column {
        Text(text = "Stats")
    }
}

@Composable
fun PlayersFragment() {
    Column {
        Text(text = "Players")
    }
}

@Composable
fun VideosFragment() {
    Column {
        Text(text = "Videos")
    }
}

@Preview(showBackground = true)
@Composable
fun showPreview() {
    SprotifyTheme {
        PastMatchesDetailScreen()

    }
}
