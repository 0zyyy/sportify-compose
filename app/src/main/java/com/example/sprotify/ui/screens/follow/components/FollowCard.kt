package com.example.sprotify.ui.screens.follow.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R

@Composable
fun FollowCard(
    footballPos: String? = ""
) {
    Box(
        modifier = Modifier
            .offset(x = 0.dp, y = 0.dp)
            .fillMaxWidth()
            .height(80.dp)
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.chelsea),
                    contentDescription = "Chelsea",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )
                Column {
                    Text(
                        text = "CHELSEA", style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = 16.sp,
                            color = Color(0xFF150000),
                            fontWeight = FontWeight.SemiBold
                        )
                    )// Child views.
                    if(footballPos != ""){
                        Text(text = footballPos!!)
                    }
                }
            }
            FollowButton()
        }
    }
}


@Composable
fun FollowButton() {
    val contextForToast = LocalContext.current.applicationContext
    Button(
        onClick = {
            // click event
            Toast.makeText(contextForToast, "Clicked!", Toast.LENGTH_SHORT).show()
        },
        shape = CutCornerShape(
            topStart = 50f,
            topEnd = 50f,
            bottomEnd = 50f,
            bottomStart = 50f,
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF150000)
        ),
        modifier = Modifier
            .width(116.dp)
            .height(72.dp)
    ) {
        // add button content here.
        // all the items are added in a row
//        Icon(imageVector = Icons.Default.Check, contentDescription = "FOLLOW ICON")
        Spacer(modifier = Modifier.width(width = 8.dp))
        Text(
            text = "FOLLOW", style = MaterialTheme.typography.headlineMedium.copy(
                fontSize = 16.sp,
                lineHeight = 10.sp
            )
        )
    }
}