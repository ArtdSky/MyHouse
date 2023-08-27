package com.example.myhouse.presentation.screens.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.myhouse.R

@Composable
fun CameraCard(
    url: String,
    name: String,
    id: Int,
    favorites: Boolean,
    rec: Boolean,
    pressedCardId: MutableState<Int?>,
    onEditClick: (Int?) -> Unit
) {
    val offsetX by animateFloatAsState(if (pressedCardId.value == id) -80f else 0f, label = "")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 14.dp)
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(279.dp)
                .offset(x = offsetX.dp)
                .clickable {
                    pressedCardId.value = if (pressedCardId.value == id) null else id
                }
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
                    if (rec) {
                        Image(
                            painter = painterResource(R.drawable.record),
                            contentDescription = "Record",
                            modifier = Modifier
                                .width(24.dp)
                                .height(16.dp)
                                .align(Alignment.TopStart)
                                .offset(10.dp, 10.dp)
                        )
                    }
                    if (favorites) {
                        Image(
                            painter = painterResource(R.drawable.star_fill),
                            contentDescription = "Favorites",
                            modifier = Modifier
                                .size(24.dp)
                                .align(Alignment.TopEnd)
                                .offset((-10).dp, 10.dp)
                        )
                    }

                    Image(
                        painter = painterResource(R.drawable.play_button),
                        contentDescription = "Play button",
                        modifier = Modifier
                            .size(60.dp)
                            .align(Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp)
                        .background(Color.White)
                        .clickable {
                            onEditClick(id)
                        },
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

        if (pressedCardId.value == id) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 14.dp)
            ) {
                IconButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.Transparent, CircleShape)
                        .border(1.dp, Color(0xFFE5E5E5), CircleShape)
                ) {
                    Image(
                        painter = painterResource(R.drawable.star),
                        contentDescription = "Добавить в избранное",
                    )
                }
            }

        }

    }
}