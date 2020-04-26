package ru.sport.home.screens.menu

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_menu.*
import ru.sport.common.BaseActivity
import ru.sport.common.adapter.DelegateAdapter
import ru.sport.common.utils.ComponentProvider
import ru.sport.home.R
import ru.sport.home.screens.menu.di.ExerciseTypeComponent
import ru.sport.uikit.ExerciseView
import javax.inject.Inject

class MenuActivity : BaseActivity(R.layout.activity_menu),
    ComponentProvider<ExerciseTypeComponent> {

    override val component by lazy { ExerciseTypeComponent.init(this) }

    private val adapter = DelegateAdapter.Builder()
        .addDelegate(ExerciseView.ViewModel::class.java, ExerciseView.Delegate())
        .build()

    @Inject
    lateinit var vm: MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
        initRecycler()
    }

    private fun initRecycler() {
        list.adapter = adapter
        list.layoutManager = GridLayoutManager(this, 2)
    }
}
