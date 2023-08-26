package com.example.myhouse.presentation.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CameraCard(
    url: String,
    name: String,
    id: Int,
    favorites: Boolean,
    rec: Boolean,
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(279.dp)
            .padding(vertical = 8.dp, horizontal = 14.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(207.dp)
                    .fillMaxWidth(),
            ) {
                AsyncImage(
                    model = url,
                    contentDescription = name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
                    .background(Color.White),
            ) {
                Text(
                    text = name,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxHeight()
                        .wrapContentSize(Alignment.Center)
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                        .background(Color.White)
                )
            }
        }
    }
}