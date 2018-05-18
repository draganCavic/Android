package com.example.drcavic.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    protected fun buClick(view:View) {
        val buSelected = view as Button
        var cellId = 0
        when(buSelected.id){
            R.id.b1 -> cellId = 1
            R.id.b2 -> cellId = 2
            R.id.b3 -> cellId = 3
            R.id.b4 -> cellId = 4
            R.id.b5 -> cellId = 5
            R.id.b6 -> cellId = 6
            R.id.b7 -> cellId = 7
            R.id.b8 -> cellId = 8
            R.id.b9 -> cellId = 9
        }


        PlayGame(cellId, buSelected)
        CheckWins()
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun PlayGame(cellId:Int, buSelected:Button){
        if(activePlayer == 1){
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)
            activePlayer = 2
            AutoPlay()
        }
        else{
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellId)
            activePlayer = 1
        }
        buSelected.isEnabled = false
    }

    fun CheckWins(){
        var winner = 0
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1
        else if(player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2
        else if(player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1
        else if(player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2
        else if(player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1
        else if(player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2

        else if(player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1
        else if(player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2
        else if(player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1
        else if(player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2
        else if(player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1
        else if(player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2

        if (winner != 0){
            if (winner == 1)
                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
        }
    }

    fun AutoPlay(){
        var emptyCells = ArrayList<Int>()
        for(cellId in 1..9)
        {
            if(!(player1.contains(cellId) || player2.contains(cellId)))
                emptyCells.add(cellId)
        }

        val r=Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellId = emptyCells[randIndex]
        var buSelected:Button?
        when(cellId){
            1-> buSelected=b1
            2-> buSelected=b2
            3-> buSelected=b3
            4-> buSelected=b4
            5-> buSelected=b5
            6-> buSelected=b6
            7-> buSelected=b7
            8-> buSelected=b8
            9-> buSelected=b9
            else ->{
                buSelected=b1
            }
        }
        PlayGame(cellId, buSelected)
    }
}
