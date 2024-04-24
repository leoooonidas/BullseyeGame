package com.leonidaspastras.bullseye3

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameState = GameState(
            targetValue = Random.nextInt(0..100)
        )
        setContent {
            // Source:
            // https://developer.android.com/training/system-ui/status#:~:text=hides%20and%20shows.-,Hide%20the%20Status%20Bar%20on%20Android%204.1%20and%20Higher,-You%20can%20hide
            // Hide the status bar.
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            // Remember that you should never show the action bar if the
            // status bar is hidden, so hide that too if necessary.
            actionBar?.hide()
            HomePage(gameState)
        }
    }
}

// This is a dummy change






