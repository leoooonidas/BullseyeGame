package com.leonidaspastras.bullseye3.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.leonidaspastras.bullseye3.R
@Composable
fun InfoDialog(
    onConfirmation: () -> Unit,
) {

    AlertDialog(
        title = {
            Text(text = "Info")
        },
        text = {
            Text(text = "hello world!")
        },
        onDismissRequest = {},
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(
                    text = "OK",
                    color = colorResource(id = R.color.sick_red)
                )
            }
        },
        shape = RoundedCornerShape(10),
        containerColor = Color.White
    )
}
