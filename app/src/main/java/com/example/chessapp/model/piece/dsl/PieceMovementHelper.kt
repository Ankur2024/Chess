package com.example.chessapp.model.piece.dsl

import androidx.compose.ui.unit.IntOffset
import com.example.chessapp.model.board.BoardXCoordinates
import com.example.chessapp.model.board.BoardYCoordinates
import com.example.chessapp.model.piece.Piece


fun Piece.getMoves(
    piece: List<Piece>,
    maxMovements: Int,
    getPosition: (Int)-> IntOffset,
    canCapture: Boolean,
    captureOnly: Boolean
): Set<IntOffset> {
    val moves = mutableSetOf<IntOffset>()

    for(i in 1..maxMovements){
        val targetPosition =  getPosition(i)
        if(targetPosition.x !in BoardXCoordinates && targetPosition.y !in BoardYCoordinates){
            break
        }
        val targetPiece = piece.find { it.position == targetPosition }
        if(targetPiece != null){
            if(targetPiece.color != this.color && canCapture){
                moves.add(targetPosition)
            }
            break
        } else if(captureOnly){
            break
        } else{
            moves.add(targetPosition)
        }
    }
    return moves
}