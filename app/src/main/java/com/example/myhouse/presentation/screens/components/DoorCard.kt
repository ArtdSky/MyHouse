package com.example.myhouse.presentation.screens.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
fun DoorCard(
    name: String,
    url: String? = null,
    room: String? = null,
    id: Int? = null,
    favorites: Boolean? = null,
    pressedCardId: MutableState<Int?>

) {
    val offsetX by animateFloatAsState(if (pressedCardId.value == id) -80f else 0f)

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
            if (url != null) {
                Box {
                    AsyncImage(
                        model = url,
                        contentDescription = name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(279.dp)
                            .fillMaxWidth()
                    )
                }
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
                        Text(
                            text = name,
                            textAlign = TextAlign.Start,
                            modifier = Modifier

                        )
                        Text(
                            text = "В сети",
                            textAlign = TextAlign.Start,
                            modifier = Modifier

                        )
                    }

                    IconButton(onClick = {

                    }) {
                        Image(
                            painter = painterResource(if (room != null) R.drawable.lockon else R.drawable.lockoff),
                            contentDescription = room
                        )

                    }
                }
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .background(Color.White)
                        .height(72.dp)
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = name,
                        textAlign = TextAlign.Start,
                        modifier = Modifier

                    )
                    IconButton(onClick = {

                    }) {
                        Image(
                            painter = painterResource(if (room != null) R.drawable.lockon else R.drawable.lockoff),
                            contentDescription = room
                        )

                    }
                }
            }

        }
    }
}