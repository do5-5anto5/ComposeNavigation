package com.do55anto5.composenavigation.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.do55anto5.composenavigation.navigation.routes.ProductRoutes.ProductDetailsScreenRoute
import com.do55anto5.composenavigation.navigation.routes.ProductRoutes.ProductListScreenRoute
import com.do55anto5.composenavigation.screens.ProductDetailsScreen
import com.do55anto5.composenavigation.screens.ProductListScreen

@Composable
fun ProductsNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = ProductListScreenRoute) {
        composable<ProductListScreenRoute> {
            ProductListScreen(
                navigateToProductDetailsScreen = { productName ->
                    navHostController.navigate(ProductDetailsScreenRoute(name = productName))
                }
            )
        }
        composable<ProductDetailsScreenRoute> { backStackEntry ->
            val product: ProductDetailsScreenRoute = backStackEntry.toRoute()
            ProductDetailsScreen(
                name = product.name,
                onBtnBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}