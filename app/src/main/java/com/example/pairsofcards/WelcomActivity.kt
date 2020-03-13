package com.example.pairsofcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcom.*

class WelcomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom)
        start_new_game.setOnClickListener {
//            startActivity(Intent(this, Main2Activity::class.java))
        val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}
