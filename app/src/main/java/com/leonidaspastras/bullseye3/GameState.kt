package com.leonidaspastras.bullseye3

data class GameState(
    var sliderPosition: Float = 50f,
    val targetValue: Int = -1,
    var totalScore: Int = 0,
    var roundCount: Int = 0
)