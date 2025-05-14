package it.p00334000265.quizbit

import android.content.Context
import android.content.SharedPreferences


object PrefsManager {
    private const val PREFS_NAME = "QuizPrefs"
    private const val KEY_COINS = "coins"
    private const val KEY_USERNAME = "username"

    private lateinit var prefs: SharedPreferences

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveCoins(value: Int) {
        prefs.edit().putInt(KEY_COINS, value).apply()
    }

    fun getCoins(): Int = prefs.getInt(KEY_COINS, 0)

    fun saveUsername(name: String) {
        prefs.edit().putString(KEY_USERNAME, name).apply()
    }

    fun getUsername(): String = prefs.getString(KEY_USERNAME, "Player") ?: "Player"
}