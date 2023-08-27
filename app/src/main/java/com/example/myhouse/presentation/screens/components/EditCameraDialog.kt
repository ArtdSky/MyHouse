package com.example.myhouse.presentation.screens.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.myhouse.domain.models.Camera

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditCameraDialog(
    camera: Camera?,
    onConfirm: (Camera) -> Unit,
    onDismiss: () -> Unit

) {
    val newName = remember { mutableStateOf(camera?.name ?: "") }

    if (camera != null) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text("Редактировать имя камеры") },
            text = {
                TextField(
                    value = newName.value,
                    onValueChange = { newName.value = it },
                    label = { Text("Имя двери") }
                )
            },
            confirmButton = {
                Button(onClick = {
                    onConfirm(camera.copy(name = newName.value))
                    onDismiss()
                }) {
                    Text("Сохранить")
                }
            },
            dismissButton = {
                Button(onClick = { onDismiss() }) {
                    Text("Отмена")
                }
            }
        )
    }

}