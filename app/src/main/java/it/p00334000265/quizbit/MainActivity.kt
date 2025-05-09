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
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import android.app.AlertDialog
import android.widget.EditText

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

        editNameButton.setOnClickListener {
            val input = EditText(this)
            input.hint = "Enter your name"

            AlertDialog.Builder(this)
                .setTitle("Edit Name")
                .setMessage("Enter your new name:")
                .setView(input)
                .setPositiveButton("Save") { dialog, _ ->
                    val newName = input.text.toString()
                    if (newName.isNotEmpty()) {
                        name = newName
                        nameView.text = "Hi, $name"
                    }
                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        if (name.isEmpty()) {
            name = "Guest"
        }
        nameView.text = "Hi, $name"
        coinView.text = coins.toString()
        singlePlayerButton.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            coinView.text = coins.toString()
        }
        val checkAllCheckBox = findViewById<CheckBox>(R.id.check_allCheckBox)
        val science = findViewById<CheckBox>(R.id.scienceCheckBox)
        val coding = findViewById<CheckBox>(R.id.codingCheckBox)
        val geography = findViewById<CheckBox>(R.id.geographyCheckBox)
        val history = findViewById<CheckBox>(R.id.historyCheckBox)
        val music = findViewById<CheckBox>(R.id.musicCheckBox)
        val art = findViewById<CheckBox>(R.id.artCheckBox)
        val shows = findViewById<CheckBox>(R.id.showsCheckBox)
        val general = findViewById<CheckBox>(R.id.generalCheckBox)
        val allCheckBoxes = listOf(science, coding, geography, history, music, art, shows, general)

        checkAllCheckBox.setOnCheckedChangeListener { _, isChecked ->
            allCheckBoxes.forEach { it.isChecked = isChecked }
        }


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
    }
    override fun onResume() {
        super.onResume()
        val nameView = findViewById<TextView>(R.id.textView2)
        val coinView = findViewById<TextView>(R.id.textView3)
        nameView.text = "Hi, " + name
        coinView.text = coins.toString()
    }
}
