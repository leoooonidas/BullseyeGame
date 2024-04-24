package com.leonidaspastras.bullseye3.ui.bottomRowFiles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CircleButton(
        icon: ImageVector,
        iconDescription: String,
        onClick: () -> Unit
) {
    return Button(
        onClick = { onClick() },
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        modifier= Modifier.size(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
    ) {
        Icon(
            icon,
            iconDescription
        )
    }
}