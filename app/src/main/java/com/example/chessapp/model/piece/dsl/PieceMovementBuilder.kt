package com.example.chessapp.model.piece.dsl

import androidx.compose.ui.unit.IntOffset
import com.example.chessapp.model.piece.Piece

fun Piece.buildPieceMovement(
    pieces: List<Piece>,
    block: PieceMovementBuilder.() -> Unit
): Set<IntOffset>{
  val builder = PieceMovementBuilder(
      piece = this,
      pieces = pieces
  )
    builder.block()
    return builder.build()
}

class PieceMovementBuilder(
    private val piece: Piece,
    private val pieces: List<Piece>
) {
    private val moves = mutableSetOf<IntOffset>()

    fun straightMoves(
        movement: StraightMovement,
        maxMovements: Int = 7,
        canCapture: Boolean = true,
        captureOnly: Boolean = false
    ){
        moves.addAll(
            piece.getStraightMoves(
                piece = pieces,
                movement = movement,
                maxMovements = maxMovements,
                canCapture = canCapture,
                captureOnly = captureOnly
            )
        )
    }

    fun diagonalMoves(
        movement: DiagonalMovement,
        maxMovements: Int = 7,
        canCapture: Boolean = true
    ){
        moves.addAll(
            piece.getDiagonalMoves (
                piece = pieces,
                movement = movement,
                maxMovements = maxMovements,
                canCapture = canCapture
            )
        )
    }

    fun build(): Set<IntOffset> = moves.toSet()
}