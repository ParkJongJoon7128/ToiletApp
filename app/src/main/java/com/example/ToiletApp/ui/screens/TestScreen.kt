package com.example.ToiletApp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ToiletApp.navigation.NAV_Route
import com.example.ToiletApp.navigation.RouteAction

@Composable
fun TestScreen(routeAction: RouteAction, value1: String, value2: String) {
    // Logics

    LaunchedEffect(key1 = value1, key2 = value2) {
        Log.d("TestScreen", "전달받은 값: $value1")
        Log.d("TestScreen", "전달받은 값: $value2")
    }

    // Views
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp)
            .imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DummyText(routeAction = routeAction, toilet1 = value1, toilet2 = value2)
    }
}

@Composable
fun DummyText(routeAction: RouteAction, toilet1: String, toilet2: String) {
    Row(modifier = Modifier
        .clickable {
            routeAction.goBack()
        }
        .background(Color.LightGray)
        .fillMaxWidth()
        .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "${toilet1}")
        Text(text = "${toilet2}")
    }

}
