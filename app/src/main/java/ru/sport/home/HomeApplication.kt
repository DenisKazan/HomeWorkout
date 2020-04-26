package ru.sport.home

import android.app.Application
import ru.sport.home.dagger.ComponentInjector

class HomeApplication: Application() {

    val componentInjector: ComponentInjector by lazy { ComponentInjector(this) }


    override fun onCreate() {
        componentInjector.getAppComponent().inject(this)
        super.onCreate()
    }
}
