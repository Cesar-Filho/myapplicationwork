package com.example.myapplication.repository

import com.example.myapplication.entity.Question

class Questions {

    companion object {
        fun list(): ArrayList<Question> {
            var questions = arrayListOf<Question>()
            asking.forEach {
                questions.add(Question(it, options))
            }
            return questions
        }

        private val asking = arrayListOf(
            "Quanto é 2+1?",
            "Quanto é 1+2?",
            "Quanto é 1+1+1?",
            "Quanto é 0+1+2?",
            "Quanto é 1+2+0?",
            "Quanto é 1+0+2+0?",
            "Quanto é 1+1+0+1+0?",
            "Quanto é 0+0+1+2+0?",
            "Quanto é 1-1+1+1+1+0?",
            "Quanto é 1+2-1+2-1+0?"
        )

        private val options = arrayListOf(
            "1",
            "2",
            "3",
            "4"
        )
    }
}