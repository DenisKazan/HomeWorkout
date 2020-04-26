package ru.sport.home.dagger

import android.content.Context

val Context.componentInjector: ComponentInjector
    get() = ComponentInjector.get(this)

val Context.appComponent: AppComponent
    get() = componentInjector.getAppComponent()
