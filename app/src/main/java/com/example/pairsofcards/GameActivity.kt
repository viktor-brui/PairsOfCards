package com.example.pairsofcards

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pairsofcards.R.drawable.*
import kotlinx.android.synthetic.main.content_game.*


class GameActivity : AppCompatActivity() {
    val cardBack = taphere
    var clicked = 0
    var turnOver = false
    var lastClicked = -1
    var allClicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        startGame()

        btn_start.setOnClickListener { recreate() }
    }

    private fun startGame() {

        val images: MutableList<Int> = mutableListOf(
            dog, elephants, fox, kangaroo, koala, lion, monkey, raccoon,
            dog, elephants, fox, kangaroo, koala, lion, monkey, raccoon
        )

        val buttons = arrayOf(
            button1, button2, button3, button4, button5, button6, button7, button8,
            button9, button10, button11, button12, button13, button14, button15, button16
        )

        images.shuffle()
        for (i in 0..15) {
            buttons[i].text = "cardBack"
            buttons[i].textSize = 0.0F
            buttons[i].setOnClickListener {
                if (buttons[i].text == "cardBack" && !turnOver) {
                    buttons[i].setBackgroundResource(images[i])
                    buttons[i].setText(images[i])
                    if (clicked == 0) {
                        lastClicked = i
                    }
                    clicked++
                    allClicks++

                } else if (buttons[i].text !in "cardBack") {
                    buttons[i].setBackgroundResource(cardBack)
                    buttons[i].text = "cardBack"
                    clicked--
                }

                if (clicked == 2) {
                    turnOver = true
                    if (buttons[i].text == buttons[lastClicked].text) {
                        buttons[i].isClickable = false
                        buttons[lastClicked].isClickable = false
                        turnOver = false
                        clicked = 0
                    }
                } else if (clicked == 0) {
                    turnOver = false
                }
                points.text = allClicks.toString()
                if (button1.text !== "cardBack" &&
                    button2.text !== "cardBack" &&
                    button3.text !== "cardBack" &&
                    button4.text !== "cardBack" &&
                    button5.text !== "cardBack" &&
                    button6.text !== "cardBack" &&
                    button7.text !== "cardBack" &&
                    button8.text !== "cardBack" &&
                    button9.text !== "cardBack" &&
                    button10.text !== "cardBack" &&
                    button11.text !== "cardBack" &&
                    button12.text !== "cardBack" &&
                    button13.text !== "cardBack" &&
                    button14.text !== "cardBack" &&
                    button15.text !== "cardBack" &&
                    button16.text !== "cardBack" ){
                    Toast.makeText(baseContext, "Вы выграли! Ваш счёт " + allClicks.toString() + " шагов", Toast.LENGTH_LONG).show()
                    btn_start.visibility = View.VISIBLE
                }
            }
        }
    }
}


