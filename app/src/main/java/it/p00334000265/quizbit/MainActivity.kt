package it.p00334000265.quizbit

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.CheckBox
import android.widget.ImageView
import java.io.File
import android.widget.Toast
import android.widget.TextView
import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

import it.p00334000265.quizbit.QuizBit.Companion.questionList
import it.p00334000265.quizbit.QuizBit.Companion.coins
import it.p00334000265.quizbit.QuizBit.Companion.name

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) {v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val singlePlayerButton = findViewById<ImageView>(R.id.single_player_button)
        val editNameButton = findViewById<ImageView>(R.id.edit_name_button)
        val nameView = findViewById<TextView>(R.id.textView2)
        val coinView = findViewById<TextView>(R.id.textView3)
        val selectAll = findViewById<CheckBox>(R.id.selectAllCheckBox)

        val checkBoxList = listOf(
            findViewById<CheckBox>(R.id.scienceCheckBox),
            findViewById<CheckBox>(R.id.codingCheckBox),
            findViewById<CheckBox>(R.id.geographyCheckBox),
            findViewById<CheckBox>(R.id.historyCheckBox),
            findViewById<CheckBox>(R.id.musicCheckBox),
            findViewById<CheckBox>(R.id.artCheckBox),
            findViewById<CheckBox>(R.id.showsCheckBox),
            findViewById<CheckBox>(R.id.generalCheckBox)
        )

        selectAll.setOnCheckedChangeListener { _, isChecked ->
            checkBoxList.forEach { it.isChecked = isChecked }
        }

        checkBoxList.forEach { cb ->
            cb.setOnCheckedChangeListener { _, _ ->
                selectAll.isChecked = checkBoxList.all { it.isChecked }
            }
        }

        singlePlayerButton.setOnClickListener {
            Toast.makeText(this, "Hai cliccato sull'immagine!", Toast.LENGTH_SHORT).show()
        }

        editNameButton.setOnClickListener {
            Toast.makeText(this, "Hai cliccato sull'immagine!", Toast.LENGTH_SHORT).show()
        }
        /*
        editNameButton.setOnClickListener{
            val intent = Intent(this, NameActivity::class.java)
            startActivity(intent)
        }
        singlePlayerButton.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            coinView.text = coins.toString()
        }

         */
        val science = findViewById<CheckBox>(R.id.scienceCheckBox)
        val coding = findViewById<CheckBox>(R.id.codingCheckBox)
        val geography = findViewById<CheckBox>(R.id.geographyCheckBox)
        val history = findViewById<CheckBox>(R.id.historyCheckBox)
        val music = findViewById<CheckBox>(R.id.musicCheckBox)
        val art = findViewById<CheckBox>(R.id.artCheckBox)
        val shows = findViewById<CheckBox>(R.id.showsCheckBox)
        val general = findViewById<CheckBox>(R.id.generalCheckBox)
        science.setOnCheckedChangeListener{ buttonView, isChecked ->
            val c = assets.open("science.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        coding.setOnCheckedChangeListener{ buttonView, isChecked ->
            val c = assets.open("coding.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        geography.setOnCheckedChangeListener{ buttonView, isChecked ->
            val c = assets.open("geography.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        history.setOnCheckedChangeListener{ buttonView, isChecked ->
            val c = assets.open("history.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        music.setOnCheckedChangeListener{ buttonView, isChecked ->
            val c = assets.open("music.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        art.setOnCheckedChangeListener{ buttonView, isChecked ->
            val c = assets.open("art.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        shows.setOnCheckedChangeListener{ buttonView, isChecked ->
            val c = assets.open("shows.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        general.setOnCheckedChangeListener{ buttonView, isChecked ->
            val c = assets.open("general.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        super.onResume()
        nameView.text = name
        coinView.text = coins.toString()
    }
    override fun onResume() {
        super.onResume()
        val nameView = findViewById<TextView>(R.id.textView2)
        val coinView = findViewById<TextView>(R.id.textView3)
        nameView.text = "Hi, " + name
        coinView.text = coins.toString()
    }
}
