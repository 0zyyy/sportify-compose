package com.example.sprotify

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.ui.theme.SprotifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SprotifyTheme {
                // A surface container using the 'background' color from the theme
                Column {
                    Header()
                    Content()
                    BottomAppBar {
                        Text(text = "Test App Bar")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Header(){
    Box(
        modifier = Modifier
            .offset(x = 0.dp, y = 0.dp)
            .fillMaxWidth()
            .height(273.dp)
            .background(color = Color(0xFFFF5050))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "Arrow Back", tint = Color.White)
            Column {
                Text("Follow your favorite teams", style = MaterialTheme.typography.headlineMedium)
                Text("Get news,game updates highlights and more info on your favorite teams",style = MaterialTheme.typography.bodyMedium)
            }
        }
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
            items(myDate.size){ item ->
                FollowCard()
            }
        }
    }
}


@Composable
fun FollowCard(){
    Box(modifier = Modifier
        .offset(x = 0.dp, y = 0.dp)
        .fillMaxWidth()
        .height(72.dp)
        .background(color = Color(0xFFFFFFFF))
        .padding(16.dp)){
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
                Text(text = "CHELSEA", style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    color = Color(0xFF150000),
                    fontWeight = FontWeight.SemiBold
                ))// Child views.
            }

            FollowButton()

        }
    }
}



@Composable
fun FollowButton(){
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
        Text(text = "FOLLOW",style = MaterialTheme.typography.headlineMedium.copy(
            fontSize = 16.sp,
            lineHeight = 10.sp
        ))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SprotifyTheme {
        Greeting("Android")
    }
}