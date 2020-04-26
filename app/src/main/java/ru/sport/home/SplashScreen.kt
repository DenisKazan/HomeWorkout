package ru.sport.home

import android.content.Intent
import android.os.Bundle
import ru.sport.common.BaseActivity


class SplashScreen: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
