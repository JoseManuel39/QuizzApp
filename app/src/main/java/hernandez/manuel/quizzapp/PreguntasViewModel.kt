package hernandez.manuel.quizzapp

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
private const val TAG = "QuizViewModel"

private val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class PreguntasViewModel (private val savedStateHandle: SavedStateHandle): ViewModel() {




    private val questionBank = listOf(
        Pregunta(R.string.Texto_Pregunta, true),
        Pregunta(R.string.Pregunta_2, false),
        Pregunta(R.string.Pregunta_3, true),
        Pregunta(R.string.Pregunta_4, false))

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)


    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].Respuesta
    val currentQuestionText: Int
        get() = questionBank[currentIndex].TextoPregunta
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }


}