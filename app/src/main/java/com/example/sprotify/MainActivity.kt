package com.example.sprotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sprotify.ui.screens.dashboard.DashboardScreen
import com.example.sprotify.ui.screens.follow.FollowPlayersPage
import com.example.sprotify.ui.screens.notification.NotificationPage
import com.example.sprotify.ui.theme.SprotifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SprotifyTheme {
                // A surface container using the 'background' color from the theme
                DashboardScreen()
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



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SprotifyTheme {
        FollowPlayersPage()
    }
}