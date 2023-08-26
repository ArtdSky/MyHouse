package com.example.myhouse.presentation.screens.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myhouse.R
import com.example.myhouse.presentation.navigation.Screen
import com.example.myhouse.presentation.viewmodels.MainViewModel

@Composable
fun Header(
    vm: MainViewModel,
    navController: NavHostController,
    currentScreen: Screen
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
//        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Text(
                text = "Мой дом",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.circlebold)),
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 26.sp,
                    textAlign = TextAlign.Center,
                    color = Color(0xFF333333)
                ),
                modifier = Modifier
                    .padding(top = 60.dp)
                    .fillMaxWidth()
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .bottomShadow(
                        when (currentScreen) {
                            Screen.Cameras -> Color(0xFF03A9F4)
                            else -> Color.Gray
                        }
                    )
                    .background(Color.White)
                    .clickable {

                    }
            ) {
                Text(
                    text = "Камеры",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.circlebold)),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF333333)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .bottomShadow(
                        when (currentScreen) {
                            Screen.Doors -> Color(0xFF03A9F4)
                            else -> Color.Gray
                        }
                    )
                    .background(Color.White)
                    .clickable {

                    }
            ) {
                Text(
                    text = "Двери",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.circlebold)),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 16.sp,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF333333)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}

fun Modifier.bottomShadow(
    shadowColor: Color,
    offsetY: Float = 10f,
    alpha: Float = 0.3f
) = drawWithContent {
    drawContent()
    drawRect(
        color = shadowColor.copy(alpha = alpha),
        size = Size(size.width, offsetY),
        topLeft = Offset(0f, size.height)
    )
}