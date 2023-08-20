package com.example.sprotify.ui.screens.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R
import com.example.sprotify.ui.theme.SprotifyTheme


@Composable
fun OnboardingScreen() {
    Header()
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .width(140.dp)
                .height(24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_red),
                contentDescription = "Logo Red",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(140.dp)
                    .height(24.dp)
            )
        }
        Content()
    }
}

@Composable
fun Header() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(514.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = "Vector",
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
                .height(495.dp)
                .align(Alignment.CenterEnd)
                .offset(x = 90.dp, y = 0.dp),
//                .align(Alignment.End)
        )
        Image(
            painter = painterResource(id = R.drawable.football),
            contentDescription = "Football",
            modifier = Modifier
                .padding(1.dp)
                .fillMaxWidth()
                .height(495.dp)
                .align(Alignment.Center)
                .offset(x = -30.dp, y = 0.dp),
//                .align(Alignment.End)
        )
    }
}


@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = "keep an eye on the stadium",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = Color.Black,
                    fontSize = 64.sp
                ),
            )

            Text(
                text = "Watch sports live or highlights, read every news from your smartphone",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                shape = RectangleShape
            ) {
                Text(text = "Get Started")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                shape = RectangleShape
            ) {
                Text(text = "Login")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun showOnboardingScreen() {
    SprotifyTheme {
        OnboardingScreen()
    }
}