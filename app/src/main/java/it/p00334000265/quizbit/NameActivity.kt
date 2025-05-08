package it.p00334000265.quizbit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button
import it.p00334000265.quizbit.QuizBit.Companion.name

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_name)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nameEdit)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nameInput = findViewById<EditText>(R.id.name)
        val submitButton = findViewById<Button>(R.id.submit)
        submitButton.setOnClickListener {
            name = nameInput.text.toString()
            finish()
        }
    }
}