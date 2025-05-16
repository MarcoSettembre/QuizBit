package it.p00334000265.quizbit

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import it.p00334000265.quizbit.QuizBit.Companion.coins

class TrophyActivity : AppCompatActivity() {
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trophy)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.trophy)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val text = findViewById<TextView>(R.id.textView)
        val homeButton = findViewById<Button>(R.id.button)
        val coinsEarned = coins-PrefsManager.getCoins()
        PrefsManager.saveCoins(coins)
        text.text = "Congratulations! You have earned " + coinsEarned.toString() + " coins!"
        homeButton.setOnClickListener{finish()}
    }
}