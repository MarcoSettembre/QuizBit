package it.p00334000265.quizbit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.app.AlertDialog
import android.widget.EditText
import android.widget.Toast
import it.p00334000265.quizbit.QuizBit.Companion.questionList
import it.p00334000265.quizbit.QuizBit.Companion.coins
import it.p00334000265.quizbit.QuizBit.Companion.name
import it.p00334000265.quizbit.QuizBit.Companion.hardMode

class MainActivity : AppCompatActivity() {
    private var isReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        PrefsManager.init(this)
        coins = PrefsManager.getCoins()
        name = PrefsManager.getUsername()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val singlePlayerButton = findViewById<ImageView>(R.id.single_player_button)
        val editNameButton = findViewById<ImageView>(R.id.edit_name_button)
        val nameView = findViewById<TextView>(R.id.textView2)
        val coinView = findViewById<TextView>(R.id.textView3)

        nameView.text = "Hi, $name"
        coinView.text = coins.toString()

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
                        PrefsManager.saveUsername(newName)
                    }
                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
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

        singlePlayerButton.setOnClickListener {
            if (science.isChecked || coding.isChecked || geography.isChecked || history.isChecked || music.isChecked || art.isChecked || shows.isChecked || general.isChecked)
                isReady = true

            if (science.isChecked) {
                val c = assets.open("science.txt").bufferedReader().useLines { it.toList() }
                for (line in c)
                    questionList.add(line)
            }
            if (coding.isChecked) {
                val c = assets.open("coding.txt").bufferedReader().useLines { it.toList() }
                for (line in c)
                    questionList.add(line)
            }
            if (geography.isChecked) {
                val c = assets.open("geography.txt").bufferedReader().useLines { it.toList() }
                for (line in c)
                    questionList.add(line)
            }
            if (history.isChecked) {
                val c = assets.open("history.txt").bufferedReader().useLines { it.toList() }
                for (line in c)
                    questionList.add(line)
            }
            if (music.isChecked) {
                val c = assets.open("music.txt").bufferedReader().useLines { it.toList() }
                for (line in c)
                    questionList.add(line)
            }
            if (art.isChecked) {
                val c = assets.open("art.txt").bufferedReader().useLines { it.toList() }
                for (line in c)
                    questionList.add(line)
            }
            if (shows.isChecked) {
                val c = assets.open("shows.txt").bufferedReader().useLines { it.toList() }
                for (line in c)
                    questionList.add(line)
            }
            if (general.isChecked) {
                val c = assets.open("general.txt").bufferedReader().useLines { it.toList() }
                for (line in c)
                    questionList.add(line)
            }

            if (isReady) {
                AlertDialog.Builder(this)
                    .setTitle("Select the difficulty level")
                    .setMessage("Hard mode will give you 15 seconds to answer each question")
                    .setNegativeButton("Hard") { dialog, _ ->
                        hardMode = true
                        dialog.dismiss()
                        val intent = Intent(this, QuestionActivity::class.java)
                        startActivity(intent)
                    }
                    .setPositiveButton("Easy") { dialog, _ ->
                        hardMode = false
                        dialog.dismiss()
                        val intent = Intent(this, QuestionActivity::class.java)
                        startActivity(intent)
                    }
                    .setNeutralButton("Dismiss") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()

            } else {
                Toast.makeText(this, "Select at least one category!", Toast.LENGTH_SHORT).show()
            }
        }

        checkAllCheckBox.setOnCheckedChangeListener { _, isChecked ->
            allCheckBoxes.forEach { it.isChecked = isChecked }
        }
    }

    override fun onResume() {
        super.onResume()
        val nameView = findViewById<TextView>(R.id.textView2)
        val coinView = findViewById<TextView>(R.id.textView3)
        name = PrefsManager.getUsername()
        coins = PrefsManager.getCoins()
        nameView.text = "Hi, $name"
        coinView.text = coins.toString()
        val checkboxes = listOf(R.id.scienceCheckBox, R.id.codingCheckBox, R.id.geographyCheckBox, R.id.historyCheckBox, R.id.musicCheckBox, R.id.artCheckBox, R.id.showsCheckBox, R.id.generalCheckBox)
        for (checkbox in checkboxes) {
            val checkBox = findViewById<CheckBox>(checkbox)
            checkBox.isChecked = false
        }
        val all = findViewById<CheckBox>(R.id.check_allCheckBox)
        all.isChecked = false
        questionList.clear()
        isReady = false
    }
}