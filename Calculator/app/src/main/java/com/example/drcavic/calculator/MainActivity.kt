package com.example.drcavic.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view:View)
    {
        if(isNewOp)
            etShow.setText("")
        isNewOp = false
        val buSelected = view as Button
        var buClickValue: String = etShow.text.toString()
        when(buSelected.id){
            bu0.id ->
                buClickValue += "0"
            bu1.id ->
                buClickValue += "1"
            bu2.id ->
                buClickValue += "2"
            bu3.id ->
                buClickValue += "3"
            bu4.id ->
                buClickValue += "4"
            bu5.id ->
                buClickValue += "5"
            bu6.id ->
                buClickValue += "6"
            bu7.id ->
                buClickValue += "7"
            bu8.id ->
                buClickValue += "8"
            bu9.id ->
                buClickValue += "9"
            buDot.id ->
                buClickValue += "."
            buPlusMinus.id ->
                buClickValue = "-" + buClickValue
        }
        etShow.setText(buClickValue)
    }
    var op = "*"
    var oldNumber = ""
    var isNewOp = true
    fun buOpEvent(view:View){
        val buSelected = view as Button
        when(buSelected.id){
            buMul.id ->
                    op = "*"
            buDiv.id ->
                    op = "/"
            buSub.id ->
                    op = "-"
            buSum.id ->
                    op = "+"
        }
        oldNumber = etShow.text.toString()
        isNewOp = true
    }
    fun buEqEvent(view:View){
        var newNumber = etShow.text.toString()
        var finalNumber:Double? = null
        when(op){
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        etShow.setText(finalNumber.toString())
        isNewOp = true
    }
    fun buPercentEvent(view:View){
        val number:Double = etShow.text.toString().toDouble()/100
        etShow.setText(number.toString())
        isNewOp = true
    }
    fun buCleanEvent(view:View){
        etShow.setText("0")
        isNewOp = true
    }
}
