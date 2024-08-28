package com.do55anto5.composenavigation.screens.details

import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailsParameter(
    val id: Int,
    val name: String,
    val price: Double
)