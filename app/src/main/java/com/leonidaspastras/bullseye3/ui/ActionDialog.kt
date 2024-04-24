package com.leonidaspastras.bullseye3.ui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.leonidaspastras.bullseye3.R

@Composable
fun ActionDialog(
    onConfirmation: () -> Unit,
    titleText: String,
    mainText: String
) {

    AlertDialog(
        title = {
            Text(text = titleText)
        },
        text = {
            Text(
                text = mainText,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
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
