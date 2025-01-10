package com.example.chessapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chessapp.ui.app.ChessSquare


@Composable
fun Board() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
    ) {
        Column {
            for (rank in 8 downTo 1) { // Iterate ranks from 8 to 1
                Row(modifier = Modifier.weight(1f)) {
                    for (file in 1..8) { // Iterate files from 1 to 8
                        val isDarkSquare = (rank + file) % 2 == 1
                        ChessSquare(
                            isDarkSquare = isDarkSquare,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun jbsds(){
    Board()
}