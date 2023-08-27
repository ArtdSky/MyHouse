package com.example.myhouse.presentation.screens.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myhouse.R

@Composable
fun DoorCard(
    name: String,
    url: String? = null,
    room: String? = null,
    id: Int? = null,
    favorites: Boolean? = null,
    pressedCardId: MutableState<Int?>,
    onEditClick: (Int?) -> Unit
) {
    val offsetX by animateFloatAsState(if (pressedCardId.value == id) -100f else 0f, label = "")

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
                .padding(vertical = 8.dp, horizontal = 14.dp)
                .offset(x = offsetX.dp)
                .clickable {
                    pressedCardId.value = if (pressedCardId.value == id) null else id
                }
        ) {
            Column {
                url?.let {
                    Box(
                        modifier = Modifier
                            .height(279.dp)
                            .fillMaxWidth()
                    ) {
                        AsyncImage(
                            model = it,
                            contentDescription = name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                        Image(
                            painter = painterResource(R.drawable.play_button),
                            contentDescription = "Play button",
                            modifier = Modifier
                                .size(60.dp)
                                .align(Alignment.Center)
                        )
                    }
                }

                DoorCardContent(
                    name = name,
                    room = room,
                    isOnline = url != null
                )
            }
        }
        if (pressedCardId.value == id) {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(start = 5.dp, end = 14.dp)
            ) {
                IconButton(
                    onClick = {
                        onEditClick(id)
                    },
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.Transparent, CircleShape)
                        .border(1.dp, Color(0xFFE5E5E5), CircleShape)
                ) {
                    Image(
                        painter = painterResource(R.drawable.edit),
                        contentDescription = room,
                        modifier = Modifier

                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color.Transparent, CircleShape)
                        .border(1.dp, Color(0xFFE5E5E5), CircleShape)
                ) {
                    Image(
                        painter = painterResource(R.drawable.star),
                        contentDescription = room,
                        modifier = Modifier

                    )
                }
            }

        }
    }
}

@Composable
fun DoorCardContent(
    name: String,
    room: String? = null,
    isOnline: Boolean = false
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color.White)
            .height(72.dp)
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        Column {
            Text(text = name, textAlign = TextAlign.Start)
            if (isOnline) {
                Text(text = "В сети", textAlign = TextAlign.Start, color = Color(0xFF999999), fontSize = 14.sp)
            }
        }

        IconButton(onClick = { }) {
            Image(
                painter = painterResource(if (room != null) R.drawable.lockon else R.drawable.lockoff),
                contentDescription = room
            )
        }
    }
}
