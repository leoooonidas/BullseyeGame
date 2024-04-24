package com.leonidaspastras.bullseye3.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leonidaspastras.bullseye3.GameState
import com.leonidaspastras.bullseye3.R

@Composable
fun InstructionText(modifier: Modifier) {
    Box (modifier = modifier) {
        Text(
            modifier = Modifier
                //.weight(1f)
                .align(Alignment.BottomEnd),
            text = stringResource(R.string.instruction_text),
            style = MaterialTheme.typography.titleMedium.copy(
                letterSpacing = 1.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun TargetText(
    modifier: Modifier,
    gameState: GameState
) {
    Box (modifier = modifier) {
        Text(
            modifier = Modifier
                .padding(top = 16.dp),
            text = gameState.targetValue.toString(),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}