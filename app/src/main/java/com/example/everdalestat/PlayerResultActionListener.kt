package com.example.everdalestat

import com.example.everdalestat.model.PlayerResult

interface PlayerResultActionListener {


    fun onDeletePlayerResult(playerResult: PlayerResult)

    fun onEditPlayerResult(playerResult: PlayerResult)
}