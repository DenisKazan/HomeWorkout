package ru.sport.home.screens.menu

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ru.sport.home.R
import ru.sport.home.screens.exercise.ExerciseActivity
import javax.inject.Inject

interface IMenuRouter {
    fun showAlertDialog(titleRes: Int, messageRes: Int, action: (() -> Unit)? = null)
    fun addNewExercise()
    fun openExerciseScreen()
}

class MenuRouter
    @Inject constructor(private val activity: AppCompatActivity): IMenuRouter {

    override fun showAlertDialog(titleRes: Int, messageRes: Int, action: (() -> Unit)?) {
        AlertDialog.Builder(activity)
            .setTitle(titleRes)
            .setMessage(messageRes)
            .setPositiveButton(R.string.ok) {_,_ -> action?.invoke() }
            .show()
    }

    override fun addNewExercise() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openExerciseScreen() {
        activity.startActivity(ExerciseActivity.getIntent(activity))
    }

}
