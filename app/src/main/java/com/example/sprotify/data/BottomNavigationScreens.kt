package com.example.sprotify.data

import androidx.annotation.StringRes
import com.example.sprotify.R

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: Int
) {
    object Dashboard : BottomNavigationScreens(
        "Dashboard", R.string.dashboard_route, R.drawable.home_out
    )

    object News : BottomNavigationScreens("News", R.string.news_route, R.drawable.news_out)
    object Clip : BottomNavigationScreens("Clip", R.string.clip_route, R.drawable.clip_red)
    object User : BottomNavigationScreens("User", R.string.user_route, R.drawable.user_out)
}