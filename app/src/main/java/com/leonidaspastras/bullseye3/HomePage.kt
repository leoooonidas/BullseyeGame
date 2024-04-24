package com.leonidaspastras.bullseye3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.leonidaspastras.bullseye3.ui.InstructionText
import com.leonidaspastras.bullseye3.ui.TargetText
import com.leonidaspastras.bullseye3.ui.bottomRowFiles.BottomRow
import com.leonidaspastras.bullseye3.ui.ActionDialog
import com.leonidaspastras.bullseye3.ui.HitMeButton
import com.leonidaspastras.bullseye3.ui.InfoDialog
import com.leonidaspastras.bullseye3.ui.sliderRowFiles.SliderRow
import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun HomePage(
    initGameState: GameState
) {

    val gameState = remember { mutableStateOf(initGameState) }
    val showAlertMessage = remember{ mutableStateOf(false) }
    val showInfoMessage = remember{ mutableStateOf(false) }
    var playerScore by remember { mutableIntStateOf(0) }

    // Make this lamda maybe?
    fun getActionDialogTitle(score : Int) : String {
        return when (score) {
            in 0..50 -> "Are you even trying?"
            in 51..75 -> "Good!"
            in 76..99 -> "Amazing!!"
            else -> "Perfect!!!"
        }
    }

    fun getPlayerScore() : Int {
        val playerPosition = gameState.value.sliderPosition.toInt()
        val target = gameState.value.targetValue
        val score = 100 - abs(playerPosition - target)
        return score
    }

    if (showAlertMessage.value) {

        // not sure about this
        playerScore = getPlayerScore()

        ActionDialog(
            onConfirmation = {
                showAlertMessage.value = false
                gameState.value = gameState.value.copy(
                    targetValue = Random.nextInt(1..100)
                )
            },
            titleText = getActionDialogTitle(playerScore),
            mainText = "You Scored $playerScore Points!"
        )
    }

    if (showInfoMessage.value) {
        InfoDialog(
            onConfirmation = {
                showInfoMessage.value = false
            },
        )
    }

    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.background),
        contentScale = ContentScale.Crop,
        contentDescription = "Background image")

    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {

        InstructionText(
            modifier = Modifier
                .weight(15f)
                .align(Alignment.CenterHorizontally)
        )

        TargetText(
            modifier = Modifier
                .weight(23f)
                .align(Alignment.CenterHorizontally),
            gameState = gameState.value

        )

        SliderRow(
            modifier = Modifier
                .weight(10f),
            gameState = gameState
        )

        HitMeButton(
            modifier = Modifier
                .weight(20f)
                .align(Alignment.CenterHorizontally),
            //gameState = gameState
            onClickAction = {
                showAlertMessage.value = true
            }
        )

        LaunchedEffect (
            key1 = showAlertMessage.value
        ) {
            if (showAlertMessage.value) {
                val playerPosition = gameState.value.sliderPosition.toInt()
                val target = gameState.value.targetValue
                val score = 100 - abs(playerPosition - target)

                gameState.value = gameState.value.copy(
                    totalScore = gameState.value.totalScore + score,
                    roundCount = gameState.value.roundCount + 1,
                )
            }
        }

        BottomRow(
            modifier = Modifier
                .weight(20f),
            gameState = gameState,
            onClickReset = {
                gameState.value = gameState.value.copy(
                    totalScore = 0,
                    roundCount = 0,
                    targetValue = Random.nextInt(1..100)
                )
            },
            onClickInfo = {
                showInfoMessage.value = true
            }
        )
    }
}