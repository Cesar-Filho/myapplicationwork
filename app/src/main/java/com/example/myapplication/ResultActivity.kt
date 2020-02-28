package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val scores = intent.getIntExtra("SCORE", 0)
        score.text = "Sua pontuação é $scores de 10!"

        exit.setOnClickListener(this)
        reset.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.exit -> exit()
            R.id.reset -> reset()
        }
    }

    private fun exit() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun reset() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}
