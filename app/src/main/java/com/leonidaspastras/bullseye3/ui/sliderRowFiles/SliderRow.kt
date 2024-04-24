package com.leonidaspastras.bullseye3.ui.sliderRowFiles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.leonidaspastras.bullseye3.GameState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderRow(
    modifier: Modifier,
    gameState: MutableState<GameState>
) {

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.SpaceAround) {

        StaticNumber(
            value = "1",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )

        MySlider(
            modifier = Modifier
                .weight(16f),
            gameState = gameState
        )

        StaticNumber(
            value = "100",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
    }
}