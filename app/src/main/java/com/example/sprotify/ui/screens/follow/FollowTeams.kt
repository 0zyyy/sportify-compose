package com.example.sprotify.ui.screens.follow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.sprotify.ui.screens.follow.components.FollowCard
import com.example.sprotify.ui.screens.follow.components.Header


@Composable
fun FollowTeamsPage(){
    Column {
        Header(title = "Follow Your Favourite Teams", subtitleText = "Get news,game updates highlights and more info on your favorite teams")
        Content()
    }
}

@Composable
fun Content(){
    val myDate = listOf<String>("Yes","sir","Pi","1","2","3","4","5")
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
        horizontalAlignment = Alignment.End,
//        modifier = Modifier.padding(16.dp)
    ) {
        LazyColumn{
            items(myDate.size){ _ ->
                FollowCard()
            }
        }
    }
}



