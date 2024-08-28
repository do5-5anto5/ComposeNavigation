package com.do55anto5.composenavigation.screens.list

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.do55anto5.composenavigation.screens.details.ProductDetailsParameter

@Composable
fun ProductListScreen(
    navigateToProductDetailsScreen: (ProductDetailsParameter) -> Unit
) {

    val context = LocalContext.current
    val activity = context as? ComponentActivity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D60B9)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(
                text = "Product List Screen",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Button(
                onClick = {
                    navigateToProductDetailsScreen(
                        ProductDetailsParameter(
                            id = 1,
                            name = "Product 1",
                            price = 297.0,
                            // if don't pass next line, description will be null
                            description = "Product 1 description"
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                content = {
                    Text(
                        text = "Go to Details",
                        style = TextStyle(
                            color = Color(0xFF2D60B9),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            )

            Button(
                onClick = { activity?.finish() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                content = {
                    Text(
                        text = "Close app",
                        style = TextStyle(
                            color = Color(0xFF2D60B9),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(navigateToProductDetailsScreen = { })
}