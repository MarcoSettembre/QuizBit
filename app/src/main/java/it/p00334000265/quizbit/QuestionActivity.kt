package it.p00334000265.quizbit

import android.os.Bundle
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import java.io.File
import androidx.core.view.WindowInsetsCompat
import it.p00334000265.quizbit.QuizBit.Companion.questionList
import it.p00334000265.quizbit.QuizBit.Companion.coins
import it.p00334000265.quizbit.QuizBit.Companion.name

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.question)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val questionText = findViewById<TextView>(R.id.question_text)
        val optionList = findViewById<ListView>(R.id.option_list)
        val nextButton = findViewById<Button>(R.id.next_button)
        var isAnswered = false
        var questions = mutableListOf<String>()
        var i = 0
        for(i in 0..9){
            questions.add(questionList[i].toString())
        }
        for(i in 0..9){
            var parts = questions[i].split("?",",")
            questionText.text = parts[0].toString()
            var options = mutableListOf<String>()
            for(j in 1..3){
                options.add(parts[j].toString())
            }
            optionList.adapter = options as ListAdapter?
        }
    }
}