package com.example.ToiletApp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ToiletApp.data.vm.MainViewModel
import com.example.ToiletApp.ui.screens.MainScreen
import com.example.ToiletApp.ui.screens.TestScreen

enum class NAV_Route(val routeName: String, val description: String) {
    MAIN(routeName = "MAIN", description = "메인화면"), Test(
        routeName = "Test/{value}", description = "테스트"
    )
}

class RouteAction(navHostController: NavHostController) {

    // routeName 스크린으로 이동
    val navTo: (NAV_Route) -> Unit = { route ->
        navHostController.navigate(route.routeName) {
            popUpTo(route.routeName) {
                inclusive = true
            }
        }
    }

    // 값 전달 용 함수
    // NAV_Route = destination(=목적지)
    // value = 전달할 값
    val customNavTo: (NAV_Route, String?) -> Unit = { route, value ->
        val routeName =
            if (value != null) route.routeName.replace("{value}", value) else route.routeName

        navHostController.navigate(routeName) {
            popUpTo(route.routeName) {
                inclusive = true
            }
        }
    }

    // 뒤로가기
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

    // NavHost 로 네비게이션 결정
    // 네비게이션 연결할 스크린들을 설정
    NavHost(
        navController = navController, startDestination = startRoute.routeName
    ) {
        composable(NAV_Route.MAIN.routeName) {
            val vm: MainViewModel = hiltViewModel()
            MainScreen(vm = vm, routeAction = routeAction)
        }
        composable(
            NAV_Route.Test.routeName,
            // 전달받을 값(arguments) 선언
            arguments = listOf(navArgument("value") { type = NavType.StringType })
        ) {

            // 전달받을 값(arguments) 선언할때 사용한 name값과 key값 일치 시켜야 됨
            // 일치할 시: value 값 전달
            // 불일치할 시: 빈 문자열("")값 전달
            val value = it.arguments?.getString("value") ?: ""
            TestScreen(routeAction = routeAction, value = value)
        }

    }
}