package it.p00334000265.quizbit

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.CheckBox
import java.io.File

import it.p00334000265.quizbit.QuizBit.Companion.questionList

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
        val singlePlayerButton = findViewById<Button>(R.id.single_player_button)
        singlePlayerButton.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
        val science = findViewById<CheckBox>(R.id.scienceCheckBox)
        val coding = findViewById<CheckBox>(R.id.codingCheckBox)
        val geography = findViewById<CheckBox>(R.id.geographyCheckBox)
        val history = findViewById<CheckBox>(R.id.historyCheckBox)
        val music = findViewById<CheckBox>(R.id.musicCheckBox)
        val art = findViewById<CheckBox>(R.id.artCheckBox)
        val shows = findViewById<CheckBox>(R.id.showsCheckBox)
        val general = findViewById<CheckBox>(R.id.generalCheckBox)
        science.setOnCheckedChangeListener{
            val c =File("science.txt").useLines { it.toList() }
            questionList.add(c)
        }
        coding.setOnCheckedChangeListener{
            val c =File("coding.txt").useLines { it.toList() }
            questionList.add(c)
        }
        geography.setOnCheckedChangeListener{
            val c =File("geography.txt").useLines { it.toList() }
            questionList.add(c);
        }
        history.setOnCheckedChangeListener{
            val c =File("history.txt").useLines { it.toList() }
            questionList.add(c)
        }
        music.setOnCheckedChangeListener{
            val c =File("music.txt").useLines { it.toList() }
            questionList.add(c)
        }
        art.setOnCheckedChangeListener{
            val c =File("art.txt").useLines { it.toList() }
            questionList.add(c)
        }
        shows.setOnCheckedChangeListener{
            val c =File("shows.txt").useLines { it.toList() }
            questionList.add(c)
        }
        general.setOnCheckedChangeListener{
            val c =openFileInput("general.txt").bufferedReader().useLines { it.toList() }
            questionList.add(c)
        }
        fun readFile(fileName: String): List<String>
                = File(fileName).readLines()
    }
}