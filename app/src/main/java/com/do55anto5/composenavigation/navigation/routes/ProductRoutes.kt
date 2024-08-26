package com.do55anto5.composenavigation.navigation.routes

import kotlinx.serialization.Serializable

sealed class ProductRoutes {

    @Serializable
    data object ProductListScreenRoute: ProductRoutes()

    @Serializable
    data object ProductDetailsScreenRoute: ProductRoutes()
}