package com.example.everdalestat

import com.example.everdalestat.model.GameResult

interface GameResultActionListener {

    fun onDeleteGameResult(gameResult: GameResult)

    fun onDetails(resultId: Int)
}