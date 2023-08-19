package com.example.sprotify.ui.screens.dashboard

import android.util.LayoutDirection
import android.util.Log
import android.util.Size
import android.widget.Space
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.core.graphics.PathParser
import com.example.sprotify.R
import com.example.sprotify.ui.theme.Brown80
import com.example.sprotify.utils.CustomButton
import com.google.android.material.chip.Chip
import java.util.regex.Pattern


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
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
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            SearchBar()
            val list = listOf(
                "Trending", "Football", "Basketball", "Cricket"
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(list.size, itemContent = { item ->
                        Log.d("DashboardScreen", "item: $item")
                        Chip(name = list[item])
                    })
                }
            }

            DashboardHero()
        }
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
fun DashboardHero(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .background(Color.Red)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Box(modifier = Modifier
                .height(18.dp)
                .width(68.dp)
                .bac){
                Row{
                    Text(text = "\uD83D\uDD25")
                    Text(text = "Top News")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "PHEONIX SUNS VS BOSTON CELTICS", style = MaterialTheme.typography.headlineMedium)
            Row {
                Text(text = "Basketball", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Wed 12.16", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "8.00 PM", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}