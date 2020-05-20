package ru.sport.common

import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity: AppCompatActivity {

    constructor(): super()

    @ContentView
    constructor(@LayoutRes layoutRes: Int): super(layoutRes)

    protected open fun initToolbar(toolbar: Toolbar, title: String? = null) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = title
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
}
