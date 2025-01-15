package com.example.chessapp.model.piece

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.IntOffset


interface Piece{
    val color: Color
    enum class Color{
        White,
        Black;

        val isWhite get() = this == White
        val isBlack get() = this == Black
    }
    @get:DrawableRes
    val drawable: Int

    var position: IntOffset

    fun getAvailableMoves(piece: List<Piece>): Set<IntOffset>
}