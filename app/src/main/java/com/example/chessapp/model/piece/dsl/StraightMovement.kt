package com.example.chessapp.model.piece.dsl

import androidx.compose.ui.unit.IntOffset
import com.example.chessapp.model.piece.Piece

enum class StraightMovement{
    Up,
    Down,
    Left,
    Right
}

fun Piece.getStraightMoves(
    piece: List<Piece>,
    movement: StraightMovement,
    maxMovements: Int = 7,
    canCapture: Boolean = true,
    captureOnly: Boolean = false
): Set<IntOffset>{

    return getMoves(
        piece = piece,
        getPosition = {
            when(movement){
                StraightMovement.Up ->
                    IntOffset(
                        x = position.x,
                        y = position.y + it
                    )

                StraightMovement.Down ->
                    IntOffset(
                        x = position.x,
                        y = position.y - it
                    )
                StraightMovement.Left ->
                    IntOffset(
                        x = position.x - it ,
                        y = position.y
                    )
                StraightMovement.Right ->
                    IntOffset(
                        x = position.x + it,
                        y = position.y
                    )
            }
        },
        maxMovements = maxMovements,
        canCapture = canCapture,
        captureOnly = captureOnly
    )
}