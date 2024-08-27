package com.do55anto5.composenavigation.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.do55anto5.composenavigation.navigation.routes.ProductRoutes.ProductDetailsScreenRoute
import com.do55anto5.composenavigation.navigation.routes.ProductRoutes.ProductListScreenRoute
import com.do55anto5.composenavigation.screens.ProductDetailsScreen
import com.do55anto5.composenavigation.screens.ProductListScreen

@Composable
fun ProductsNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = ProductListScreenRoute) {
        composable<ProductListScreenRoute> {
            ProductListScreen(
                navigateToProductDetailsScreen = {
                    navHostController.navigate(ProductDetailsScreenRoute)
                }
            )
        }
        composable<ProductDetailsScreenRoute> {
            ProductDetailsScreen(
                onBtnBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}