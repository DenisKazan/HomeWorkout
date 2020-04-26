package ru.sport.home

import android.content.Intent
import android.os.Bundle
import ru.sport.common.BaseActivity
import ru.sport.home.screens.MenuActivity


class SplashScreen: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MenuActivity::class.java))
        finish()
    }
}
