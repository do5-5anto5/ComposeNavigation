package com.do55anto5.composenavigation.screens.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductDetailsScreen(
    parameter: ProductDetailsParameter,
    onBtnBackResult: (String) -> Unit,
    onBtnBackPressed: () -> Unit = {}
) {

    var description by remember { mutableStateOf("") }

    BackHandler {
        if (description.isNotEmpty()) {
            onBtnBackResult(description)
        } else {
            onBtnBackPressed()
        }
    }

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
                text = "Product: ${parameter.name} \n ID: ${parameter.id} \n Price: ${parameter.price}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
            )

            if (parameter.description != null) {
                Text(
                    text = "Description: ${parameter.description}",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 22.sp,
                    )
                )
            }

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

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 32.dp),
            )

            TextField(
                value = description,
                onValueChange = {
                    description = it
                }
            )

            Button(
                onClick = { onBtnBackResult(description) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                content = {
                    Text(
                        text = "Navigate back with description",
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
    ProductDetailsScreen(
        onBtnBackResult = {},
        parameter = ProductDetailsParameter(0, "", 0.0)
    )
}