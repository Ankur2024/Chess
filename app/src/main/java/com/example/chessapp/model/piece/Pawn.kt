package com.example.chessapp.model.piece

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.IntOffset
import com.example.chessapp.R

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
        val moves = mutableSetOf<IntOffset>()
        val direction = if(color.isWhite) 1 else -1
        val isFirstMove = (position.y == 2 && color.isWhite) ||
                    (position.y == 7 && color.isBlack)

        val nextPosition1 = IntOffset(
            x = position.x,
            y = position.y + direction
        )
        val nextPiece1 = piece.find { it.position == nextPosition1 }
        if(moves.add(nextPosition1))
        return moves
    }


}