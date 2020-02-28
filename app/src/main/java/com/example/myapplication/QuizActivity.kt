package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.repository.Questions
import com.squareup.picasso.Picasso


class QuizActivity : AppCompatActivity(), View.OnClickListener {
    private var count: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var imageView = findViewById<ImageView>(R.id.image)
        Picasso.get()
            .load("https://cdn.pixabay.com/photo/2015/05/08/05/09/mathematics-757566_960_720.jpg")
            .resize(400, 200)
            .centerCrop()
            .into(imageView)
        this.count = intent.getIntExtra("COUNT", 0)
        this.score = intent.getIntExtra("SCORE", 0)

        val questions = Questions.list()
        var asking = findViewById<TextView>(R.id.question)
        var option1 = findViewById<TextView>(R.id.option1)
        var option2 = findViewById<TextView>(R.id.option2)
        var option3 = findViewById<TextView>(R.id.option3)
        var option4 = findViewById<TextView>(R.id.option4)

        asking.text = questions[count].asking
        option1.text = questions[count].options[0]
        option2.text = questions[count].options[1]
        option3.text = questions[count].options[2]
        option4.text = questions[count].options[3]

        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.option3) {
            score++
        }
        if (count == 9) {
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("SCORE", score)
            }
            startActivity(intent)
            finish()
        } else {
            count++
            val intent = Intent(this, QuizActivity::class.java).apply {
                putExtra("SCORE", score)
                putExtra("COUNT", count)
            }
            startActivity(intent)
        }
    }
}
