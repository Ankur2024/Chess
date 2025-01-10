package com.example.chessapp.ui.app

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chessapp.ui.theme.square_light
import com.example.chessapp.ui.theme.square_dark


@Composable
fun ChessSquare(isDarkSquare: Boolean, modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
    ) {
        drawRect(color = if (isDarkSquare) square_dark else square_light)
    }
}