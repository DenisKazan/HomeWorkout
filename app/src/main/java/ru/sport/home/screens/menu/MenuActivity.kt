package ru.sport.home.screens.menu

import android.os.Bundle
import ru.sport.common.BaseActivity
import ru.sport.common.utils.ComponentProvider
import ru.sport.home.R
import ru.sport.home.screens.menu.di.ExerciseTypeComponent
import javax.inject.Inject

class MenuActivity : BaseActivity(R.layout.activity_menu), ComponentProvider<ExerciseTypeComponent> {

    override val component by lazy { ExerciseTypeComponent.init(this) }

    @Inject
    lateinit var vm: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }
}
