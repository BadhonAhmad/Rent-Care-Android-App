package com.example.rentcare.Graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.rentcare.BottomBarScreen
import com.example.rentcare.HomePage
import com.example.rentcare.Notifications
import com.example.rentcare.Profile

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = AuthScreen.Home.route
    ) {
        composable(route = AuthScreen.Home.route) {
//            ScreenContent(
//                name = BottomBarScreen.Home.route,
//                onClick = {
//                    navController.navigate(Graph.DETAILS)
//                }
//            )
            HomePage()
        }
        composable(route = BottomBarScreen.Profile.route) {
//            ScreenContent(
//                name = BottomBarScreen.Profile.route,
//                onClick = { }
//            )
            Profile(navController)
        }
        composable(route = BottomBarScreen.Notifications.route) {
//            ScreenContent(
//                name = BottomBarScreen.Settings.route,
//                onClick = { }
//            )
            Notifications(navController)
        }
      //  detailsNavGraph(navController = navController)
    }
}

//details
//fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
//    navigation(
//        route = Graph.DETAILS,
//        startDestination = DetailsScreen.Information.route
//    ) {
//        composable(route = DetailsScreen.Information.route) {
//            ScreenContent(name = DetailsScreen.Information.route) {
//                navController.navigate(DetailsScreen.Overview.route)
//            }
//        }
//        composable(route = DetailsScreen.Overview.route) {
//            ScreenContent(name = DetailsScreen.Overview.route) {
//                navController.popBackStack(
//                    route = DetailsScreen.Information.route,
//                    inclusive = false
//                )
//            }
//        }
//    }
//}

sealed class DetailsScreen(val route: String) {
    object Information : DetailsScreen(route = "INFORMATION")
    object Overview : DetailsScreen(route = "OVERVIEW")
}