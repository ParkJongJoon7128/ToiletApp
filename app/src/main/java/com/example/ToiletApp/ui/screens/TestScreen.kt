package com.example.ToiletApp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ToiletApp.navigation.RouteAction

@Composable
fun TestScreen(routeAction: RouteAction) {
    // Logics

    // Views
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp)
            .imePadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DummyText(routeAction = routeAction)
    }
}

@Composable
fun DummyText(routeAction: RouteAction) {
    Text(text = "여기는 두번째 스크린입니다.", modifier = Modifier.clickable { routeAction.goBack() })
}
