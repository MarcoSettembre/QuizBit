package it.p00334000265.quizbit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.Toast
import android.graphics.Color
import com.google.android.material.progressindicator.LinearProgressIndicator
import android.util.Log
import android.widget.ProgressBar
import androidx.core.view.WindowInsetsCompat
import it.p00334000265.quizbit.QuizBit.Companion.questionList
import it.p00334000265.quizbit.QuizBit.Companion.coins

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
        questionList.shuffle()
        val progressBar = findViewById<LinearProgressIndicator>(R.id.progressBar)
        val questionText = findViewById<TextView>(R.id.question_text)
        val op1 = findViewById<Button>(R.id.option1)
        val op2 = findViewById<Button>(R.id.option2)
        val op3 = findViewById<Button>(R.id.option3)
        val op4 = findViewById<Button>(R.id.option4)
        val nextButton = findViewById<Button>(R.id.next_button)
        var isAnswered = false
        var i = 0
        var parts: List<String>
        var correct = ""
        progressBar.progress= 10
        parts = questionList[i].split("?", ",")
        questionText.text = parts[0].toString() + "?"
        for (j in 1..4) {
            if (parts[j].startsWith("1"))
                correct = parts[j].substring(1)
            when (j) {
                1 -> op1.text = parts[j].substring(1)
                2 -> op2.text = parts[j].substring(1)
                3 -> op3.text = parts[j].substring(1)
                4 -> op4.text = parts[j].substring(1)
            }
        }

        fun updateProgressBar(progressBar: LinearProgressIndicator, currentIndex: Int, total: Int) {
            val progress = ((currentIndex + 1) * 100) / total
            progressBar.setProgressCompat(progress, true)
        }

        op1.setOnClickListener {
            if(!isAnswered) {
                if(op1.text == correct) {
                    coins+=100
                    op1.setBackgroundColor(Color.parseColor("#00FF00"))
                } else {
                    op1.setBackgroundColor(Color.parseColor("#FF0000"))
                    for(j in 1..4){
                        if(parts[j].substring(1)==correct){
                            when(j){
                                1 -> op1.setBackgroundColor(Color.parseColor("#00FF00"))
                                2 -> op2.setBackgroundColor(Color.parseColor("#00FF00"))
                                3 -> op3.setBackgroundColor(Color.parseColor("#00FF00"))
                                4 -> op4.setBackgroundColor(Color.parseColor("#00FF00"))
                            }
                            break
                        }
                    }
                }
                isAnswered = true
            }
        }
        op2.setOnClickListener {
            if(!isAnswered) {
                if(op2.text == correct) {
                    coins+=100
                    op2.setBackgroundColor(Color.parseColor("#00FF00"))
                } else {
                    op2.setBackgroundColor(Color.parseColor("#FF0000"))
                    for(j in 1..4){
                        if(parts[j].substring(1)==correct){
                            when(j){
                                1 -> op1.setBackgroundColor(Color.parseColor("#00FF00"))
                                2 -> op2.setBackgroundColor(Color.parseColor("#00FF00"))
                                3 -> op3.setBackgroundColor(Color.parseColor("#00FF00"))
                                4 -> op4.setBackgroundColor(Color.parseColor("#00FF00"))
                            }
                            break
                        }
                    }
                }
                isAnswered = true
            }
        }
        op3.setOnClickListener {
            if(!isAnswered) {
                if(op3.text == correct) {
                    coins+=100
                    op3.setBackgroundColor(Color.parseColor("#00FF00"))
                } else {
                    op3.setBackgroundColor(Color.parseColor("#FF0000"))
                    for(j in 1..4){
                        if(parts[j].substring(1)==correct){
                            when(j){
                                1 -> op1.setBackgroundColor(Color.parseColor("#00FF00"))
                                2 -> op2.setBackgroundColor(Color.parseColor("#00FF00"))
                                3 -> op3.setBackgroundColor(Color.parseColor("#00FF00"))
                                4 -> op4.setBackgroundColor(Color.parseColor("#00FF00"))
                            }
                            break
                        }
                    }
                }
                isAnswered = true
            }
        }
        op4.setOnClickListener {
            if(!isAnswered) {
                if(op4.text == correct) {
                    coins+=100
                    op4.setBackgroundColor(Color.parseColor("#00FF00"))
                } else {
                    op4.setBackgroundColor(Color.parseColor("#FF0000"))
                    for(j in 1..4){
                        if(parts[j].substring(1)==correct){
                            when(j){
                                1 -> op1.setBackgroundColor(Color.parseColor("#00FF00"))
                                2 -> op2.setBackgroundColor(Color.parseColor("#00FF00"))
                                3 -> op3.setBackgroundColor(Color.parseColor("#00FF00"))
                                4 -> op4.setBackgroundColor(Color.parseColor("#00FF00"))
                            }
                            break
                        }
                    }
                }
                isAnswered = true
            }
        }
        nextButton.setOnClickListener{
            if(isAnswered){
                if(i==9){
                    finish()
                } else{
                    i++
                    updateProgressBar(progressBar,i,10)
                    val defaultColor = resources.getColor(R.color.violet, theme)
                    op1.setBackgroundColor(defaultColor)
                    op2.setBackgroundColor(defaultColor)
                    op3.setBackgroundColor(defaultColor)
                    op4.setBackgroundColor(defaultColor)
                    if(i==9)
                        nextButton.text = "Finish"
                    isAnswered=false
                    parts = questionList[i].split("?", ",")
                    questionText.text = parts[0].toString() + "?"
                    for (j in 1..4) {
                        if (parts[j].startsWith("1"))
                            correct = parts[j].substring(1)
                        when (j) {
                            1 -> op1.text = parts[j].substring(1)
                            2 -> op2.text = parts[j].substring(1)
                            3 -> op3.text = parts[j].substring(1)
                            4 -> op4.text = parts[j].substring(1)
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Answer the question first!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}