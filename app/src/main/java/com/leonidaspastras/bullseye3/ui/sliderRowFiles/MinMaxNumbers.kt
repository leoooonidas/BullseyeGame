package com.leonidaspastras.bullseye3.ui.sliderRowFiles

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StaticNumber(
    value: String,
    modifier: Modifier
) {
    return Box (
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(PaddingValues(end = 16.dp)),
            text = value,
            fontWeight = FontWeight.Bold
        )
    }
}