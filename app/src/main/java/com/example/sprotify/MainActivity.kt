package com.example.sprotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sprotify.data.BottomNavigationScreens
import com.example.sprotify.ui.screens.auth.LoginScreen
import com.example.sprotify.ui.screens.dashboard.DashboardScreen
import com.example.sprotify.ui.screens.follow.FollowPlayersPage
import com.example.sprotify.ui.screens.highlights.HighlightScreen
import com.example.sprotify.ui.screens.live.WatchLiveScreen
import com.example.sprotify.ui.shared.components.BottomNavBar
import com.example.sprotify.ui.theme.SprotifyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SprotifyTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavigationScreens.Dashboard,
        BottomNavigationScreens.News,
        BottomNavigationScreens.Clip,
        BottomNavigationScreens.User
    )
    Scaffold(
        containerColor = Color(0xFFFAFAFA),
        bottomBar = {
            BottomNavBar(navController = navController, items = bottomNavItems)
        }
    ) { paddingValues ->
        MainScreenNavigationConfigurations(
            navController = navController,
            padding = paddingValues
        )
    }
}


@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController,
    padding: PaddingValues = PaddingValues(0.dp)
) {
    NavHost(navController, startDestination = BottomNavigationScreens.Clip.route) {
        composable(BottomNavigationScreens.Dashboard.route) {
            DashboardScreen()
        }
        composable(BottomNavigationScreens.News.route) {
            HighlightScreen()
        }
        composable(BottomNavigationScreens.Clip.route) {
            WatchLiveScreen()
        }
        composable(BottomNavigationScreens.User.route) {
            LoginScreen()
        }
        composable("follow/players") {
            FollowPlayersPage()
        }
        composable("follow/teams") {
            FollowPlayersPage()
        }
        composable("highlights"){
            HighlightScreen()
        }
        composable("watch-live"){
            WatchLiveScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SprotifyTheme {
        FollowPlayersPage()
    }
}