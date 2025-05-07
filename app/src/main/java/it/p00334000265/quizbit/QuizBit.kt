package it.p00334000265.quizbit
import android.app.Application
class QuizBit: Application(){
    companion object{
        var questionList = mutableListOf<Any>()
    }
}