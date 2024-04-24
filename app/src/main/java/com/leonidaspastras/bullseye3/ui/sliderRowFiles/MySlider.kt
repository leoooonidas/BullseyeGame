package com.leonidaspastras.bullseye3.ui.sliderRowFiles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.leonidaspastras.bullseye3.GameState
import com.leonidaspastras.bullseye3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySlider(
    modifier: Modifier,
    gameState: MutableState<GameState>
) {
    Box (
        modifier = modifier
    ) {

        Slider(
            value = gameState.value.sliderPosition,
            onValueChange = {
                gameState.value = gameState.value.copy(sliderPosition = it)
            },
            valueRange = 1f..100f,
            thumb = {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = R.drawable.nub),
                    contentDescription = "Slider thumb")
            },
            track = { sliderPositions ->
                SliderDefaults.Track(

                    colors = SliderDefaults.colors(
                        //thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = colorResource(id = R.color.sick_red),
                        inactiveTrackColor = colorResource(id = R.color.sick_red),
                    ),
                    modifier = Modifier.scale(scaleX = 1f, scaleY = 3f),
                    sliderPositions = sliderPositions
                )
            },
        )
    }
}