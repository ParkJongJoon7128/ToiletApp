package com.example.ToiletApp.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ToiletApp.navigation.RouteAction

@Composable
fun TestScreen(routeAction: RouteAction, value: String) {
    // Logics

    LaunchedEffect(value) {
        Log.d("TestScreen", "전달받은 값: $value")
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
        DummyText(routeAction = routeAction, toilet = value)
    }
}

@Composable
fun DummyText(routeAction: RouteAction, toilet: String) {
    Text(text = toilet, modifier = Modifier.clickable { routeAction.goBack() })
}
