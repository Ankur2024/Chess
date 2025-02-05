package com.example.chessapp.model.board

val BoardXCoordinates = List(8){
    'a'.code + it
}

val BoardYCoordinates = List(8){
    8 - it
}