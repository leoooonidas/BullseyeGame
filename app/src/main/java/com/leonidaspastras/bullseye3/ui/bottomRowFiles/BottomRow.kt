package com.leonidaspastras.bullseye3.ui.bottomRowFiles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.leonidaspastras.bullseye3.GameState

@Composable
fun BottomRow(
    modifier: Modifier,
    gameState: MutableState<GameState>,
    onClickReset: () -> Unit,
    onClickInfo: () -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly) {

        CircleButton(
            onClick = { onClickReset() },
            icon = Icons.Sharp.Refresh,
            iconDescription = "Refresh Icon"
        )

        InfoText(
            title = "Score",
            value = gameState.value.totalScore
        )

        InfoText(
            title = "Round",
            value = gameState.value.roundCount
        )

        CircleButton(
            onClick = { onClickInfo() },
            icon = Icons.Sharp.Info,
            iconDescription = "Info Icon"
        )
    }
}
