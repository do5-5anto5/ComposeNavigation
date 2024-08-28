package com.do55anto5.composenavigation.navigation.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.do55anto5.composenavigation.navigation.routes.ProductRoutes.ProductDetailsScreenRoute
import com.do55anto5.composenavigation.navigation.routes.ProductRoutes.ProductListScreenRoute
import com.do55anto5.composenavigation.navigation.serialization.serializableType
import com.do55anto5.composenavigation.screens.details.ProductDetailsParameter
import com.do55anto5.composenavigation.screens.details.ProductDetailsScreen
import com.do55anto5.composenavigation.screens.list.ProductListScreen
import kotlin.reflect.typeOf

@Composable
fun ProductsNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = ProductListScreenRoute) {
        composable<ProductListScreenRoute> { backStackEntry ->
            val description = backStackEntry.savedStateHandle.get<String>("result")
            ProductListScreen(
                description = description,
                navigateToProductDetailsScreen = { parameter ->
                    navHostController.navigate(
                        ProductDetailsScreenRoute(parameter)
                    )
                }
            )
        }
        composable<ProductDetailsScreenRoute>(
            typeMap = mapOf(typeOf<ProductDetailsParameter>() to serializableType<ProductDetailsParameter>())
        ) { backStackEntry ->
            val screenRoute: ProductDetailsScreenRoute = backStackEntry.toRoute()
            ProductDetailsScreen(
                parameter = screenRoute.parameter,
                onBtnBackResult = { description ->
                    navHostController.previousBackStackEntry?.savedStateHandle?.set(
                        "result",
                        description
                    )
                    navHostController.popBackStack()
                },
                onBtnBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}