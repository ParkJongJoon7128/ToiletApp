package com.example.ToiletApp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ToiletApp.data.vm.MainViewModel
import com.example.ToiletApp.navigation.NAV_Route
import com.example.ToiletApp.navigation.RouteAction
import com.example.ToiletApp.network.toilet.response.ToiletData

@ExperimentalComposeUiApi
@Composable
fun MainScreen(vm: MainViewModel = hiltViewModel(), routeAction: RouteAction) {
    // Logics
    val toiletList = vm.toiletList.collectAsState()

    Scaffold {
        // Views
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it.calculateTopPadding().value.dp)
                .imePadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ToiletList(toiletList = toiletList.value, routeAction = routeAction)
        }

    }

}

@Composable
fun ToiletList(toiletList: List<ToiletData>, routeAction: RouteAction) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = toiletList) {
            ToiletItem(toilet = it, routeAction = routeAction)
        }
    }
}

@Composable
fun ToiletItem(toilet: ToiletData, routeAction: RouteAction) {
    Row(
        modifier = Modifier
//        .clickable {
//            routeAction.customNavTo2(
//                NAV_Route.Test,
//                toilet.PBCTLT_PLC_NM,
//                toilet.MANAGE_INST_NM
//            )
//        }
//            .background(Color.LightGray)
            .border(1.dp, Color.Black, shape = RectangleShape)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "${toilet.PBCTLT_PLC_NM}",
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )

        Spacer(modifier = Modifier.padding(horizontal = 4.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = "위도 : ${toilet.REFINE_WGS84_LAT}")
            Text(text = "경도 : ${toilet.REFINE_WGS84_LOGT}")
        }
    }
    Spacer(modifier = Modifier.padding(vertical = 4.dp))
}