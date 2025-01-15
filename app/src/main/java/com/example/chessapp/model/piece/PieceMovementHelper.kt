package com.example.chessapp.model.piece

import androidx.compose.ui.unit.IntOffset

enum class StraightMovement{
    Up,
    Down,
    Left,
    Right
}

fun Piece.getStraightMoves(
    piece: List<Piece>,
    getPosition: (Int) -> IntOffset,
    movement: StraightMovement,
    maxMovements: Int = 7
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
            }
        }
    )
}

fun Piece.getMoves(
    piece: List<Piece>,
    maxMovements: Int = 7,
    getPosition: (Int)-> IntOffset,
): Set<IntOffset> {
    val moves = mutableSetOf<IntOffset>()

    for(i in 1..maxMovements){
        val targetPosition =  getPosition(i)
        val targetPiece = piece.find { it.position == targetPosition }
        if(targetPiece != null){
            if(targetPiece.color != this.color){
                moves.add(targetPosition)
            }
            break
        } else{
            moves.add(targetPosition)
        }
    }
    return moves
}