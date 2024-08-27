package com.do55anto5.composenavigation.screens

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ProductDetailsScreen(
    name: String,
    onBtnBackPressed: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2D60B9)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            Text(
                text = "Product Details Screen",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "Product: $name",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Button(
                onClick = onBtnBackPressed,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                content = {
                    Text(
                        text = "Go back",
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
private fun ProductDetailsScreenPreview() {
    ProductDetailsScreen(name = "")
}