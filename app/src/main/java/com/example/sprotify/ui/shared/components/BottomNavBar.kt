package com.example.sprotify.ui.shared.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sprotify.data.BottomNavigationScreens

@Composable
fun BottomNavBar(
    navController: NavHostController? = null,
    items: List<BottomNavigationScreens>
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(16.dp),
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController!!.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Log.d("BottomNavBar", "currentRoute: $currentRoute")
        items.forEach { screen ->
            NavigationBarItem(
                selected = false,
                onClick = {
                    navController?.navigate(screen.route)
                },
                icon = {
                    when (currentRoute == screen.route) {
                        true -> Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = screen.route,
                            modifier = Modifier
                                .size(24.dp),
                            tint = Color.Red
                        )

                        false -> Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = screen.route,
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                },
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun showBottomNavBar() {
    BottomNavBar(
        items = listOf(
            BottomNavigationScreens.Dashboard,
            BottomNavigationScreens.News,
            BottomNavigationScreens.Clip,
            BottomNavigationScreens.User
        )
    )
}