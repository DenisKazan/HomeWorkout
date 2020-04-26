package ru.sport.common

import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity {

    constructor(): super()

    @ContentView
    constructor(@LayoutRes layoutRes: Int): super(layoutRes)
}
