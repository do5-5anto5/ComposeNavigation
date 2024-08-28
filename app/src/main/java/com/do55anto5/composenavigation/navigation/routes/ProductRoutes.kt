package com.do55anto5.composenavigation.navigation.routes

import com.do55anto5.composenavigation.screens.details.ProductDetailsParameter
import kotlinx.serialization.Serializable

sealed class ProductRoutes {

    @Serializable
    data object ProductListScreenRoute : ProductRoutes()

    @Serializable
    data class ProductDetailsScreenRoute(
        val parameter: ProductDetailsParameter
    ) : ProductRoutes() {}
}