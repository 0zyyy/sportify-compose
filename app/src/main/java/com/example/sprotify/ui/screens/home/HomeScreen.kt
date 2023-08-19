package com.example.sprotify.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprotify.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(){
    Column {
    Header()
    Content()
    }
}

@Composable
fun Header(){
    val contextForToast = LocalContext.current.applicationContext
    Box(modifier = Modifier
        .offset(x = 0.dp, y = 0.dp)
        .fillMaxWidth()
        .height(319.dp)
        .background(color = Color(0xFFFF5050))
        .padding(16.dp)){
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Box(modifier = Modifier
                .width(140.dp)
                .height(42.dp)){
                Image(painter = painterResource(id = R.drawable.logo),"Logo Sportify", modifier = Modifier.fillMaxSize())
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column {
                Text("Welcome to Sportify App", style = MaterialTheme.typography.headlineMedium)
                Text(
                    text = "Your  Sportify ID grants you access to the exclusive offers, personalized content, and more- so you can keep being one of the best fans out there.",
                    style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
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
                        .width(150.dp)
                        .height(31.dp)
                ) {
                    // add button content here.
                    // all the items are added in a row
//        Icon(imageVector = Icons.Default.Check, contentDescription = "FOLLOW ICON")
                    Text(text = "SIGN IN OR JOIN",style = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 16.sp,
                    ))
                }
            }

        }
    }
}


@Composable
fun Content(){
    val menu = listOf<String>("Notifications","Privacy","Customer Support","App Info","App Info")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Menu()
        Spacer(modifier = Modifier.height(21.dp))
        Menu()
        Spacer(modifier = Modifier.height(21.dp))
        TitleSection(name = "OTHER OPTIONS")
        LazyColumn{
            items(menu.size){ item ->
                MenuItem(text = menu[item])
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun TitleSection(name: String){
    val contextForToast = LocalContext.current.applicationContext
    Text(text = name, style = MaterialTheme.typography.headlineMedium.copy(
        color = Color.Black,
        fontSize = 20.sp
    ), modifier = Modifier.clickable { Toast.makeText(contextForToast, "Clicked!", Toast.LENGTH_SHORT).show() })
}

@Composable
fun MenuItem(text: String){
    Text(text = text, style = MaterialTheme.typography.bodyMedium.copy(
        color = Color.Black,
        fontSize = 16.sp
    ))
}

@Composable
fun Menu(){
    Box(modifier = Modifier
        .height(66.dp)){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.width(325.dp)
            ) {
                Text(text = "MY TEAMS", style = MaterialTheme.typography.headlineMedium.copy(
                    color = Color.Black,
                    fontSize = 20.sp
                ))
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    softWrap = true,
                    maxLines = 6,
                    overflow = TextOverflow.Clip,
                    text = "Follow your favorite teams for personalized content and recommendations.",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    ))
            }
            Icon(Icons.Rounded.Add,"Add Teams", tint = Color.Black)
        }
    }
}