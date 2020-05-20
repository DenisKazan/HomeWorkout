package ru.sport.home.screens.exercise

import android.content.Context
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_exercise.*
import ru.sport.common.BaseActivity
import ru.sport.home.R

class ExerciseActivity: BaseActivity(R.layout.activity_exercise) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar(toolbarView, "Exercise")
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, ExerciseActivity::class.java)
    }
}
