package it.p00334000265.quizbit
import android.app.Application
class QuizBit: Application(){
    companion object{
        var questionList = mutableListOf<String>()
        var coins: Int = 0
        var name: String = ""
        var hardMode: Boolean = false
    }
}