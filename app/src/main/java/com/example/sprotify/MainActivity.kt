package com.example.sprotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sprotify.ui.screens.follow.FollowPlayersPage
import com.example.sprotify.ui.screens.follow.FollowTeamsPage
import com.example.sprotify.ui.theme.SprotifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SprotifyTheme {
                // A surface container using the 'background' color from the theme
                FollowTeamsPage()
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