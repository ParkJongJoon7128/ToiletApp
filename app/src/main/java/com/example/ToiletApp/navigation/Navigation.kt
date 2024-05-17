package com.example.ToiletApp.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ToiletApp.data.vm.MainViewModel
import com.example.ToiletApp.ui.screens.MainScreen
import com.example.ToiletApp.ui.screens.TestScreen

enum class NAV_Route(val routeName: String, val description: String) {
    MAIN(routeName = "MAIN", description = "메인화면"), Test(routeName = "Test", description = "테스트")
}

class RouteAction(navHostController: NavHostController) {
    val navTo: (NAV_Route) -> Unit = { route ->
        navHostController.navigate(route.routeName) {
            popUpTo(route.routeName) {
                inclusive = true
            }
        }
    }

    val goBack: () -> Unit = {
        navHostController.popBackStack()
    }
}

@ExperimentalComposeUiApi
@Composable
fun NavigationGraph(startRoute: NAV_Route = NAV_Route.MAIN) {

    // 네비게이션 컨트롤러 선언
    val navController = rememberNavController()

    // 네비게이션 라우트액션 선언
    val routeAction = remember(navController) {
        RouteAction(navController)
    }

    NavHost(
        navController = navController, startDestination = startRoute.routeName
    ) {
        composable(NAV_Route.MAIN.routeName) { backStackEntry ->
            val vm: MainViewModel = hiltViewModel()
            MainScreen(vm = vm, routeAction = routeAction)
        }
        composable(NAV_Route.Test.routeName) {
            TestScreen(routeAction = routeAction)
        }

    }
}