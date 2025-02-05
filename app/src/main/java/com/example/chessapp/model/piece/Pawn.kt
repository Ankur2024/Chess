package com.example.chessapp.model.piece

import androidx.compose.ui.unit.IntOffset
import com.example.chessapp.R
import com.example.chessapp.model.piece.dsl.DiagonalMovement
import com.example.chessapp.model.piece.dsl.StraightMovement
import com.example.chessapp.model.piece.dsl.buildPieceMovement
import com.example.chessapp.model.piece.dsl.getDiagonalMoves
import com.example.chessapp.model.piece.dsl.getStraightMoves

class Pawn (
    override val color: Piece.Color,
    override var position: IntOffset,
): Piece{

    override val drawable: Int = if(color.isWhite){
        R.drawable.pawn_light
    }else{
        R.drawable.pawn_dark
    }
    override fun getAvailableMoves(piece: List<Piece>): Set<IntOffset> {
        val isFirstMove =
            position.y == 2 && color.isWhite ||
                    position.y == 7 && color.isBlack

        return buildPieceMovement(piece) {
            straightMoves(
                movement = if (color.isWhite) StraightMovement.Up else StraightMovement.Down,
                maxMovements = if (isFirstMove) 2 else 1,
                canCapture = false
            )

            diagonalMoves(
                movement = if (color.isWhite) DiagonalMovement.UpLeft else DiagonalMovement.DownLeft,
                maxMovements = 1,
                canCapture = true
            )

            diagonalMoves(
                movement = if (color.isWhite) DiagonalMovement.UpLeft else DiagonalMovement.DownLeft,
                maxMovements = 1,
                canCapture = true
            )
        }
    }
}