package ru.sport.home.dagger

import android.app.Application
import android.content.Context
import ru.sport.common.utils.AndroidContextComponent
import ru.sport.common.utils.ContextProvider
import ru.sport.home.HomeApplication

class ComponentInjector(app: Application) {

    private val appComponent: AppComponent

    init {
        val contextProvider: ContextProvider = AndroidContextComponent
            .Initializer
            .init(app)
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .contextProvider(contextProvider)
            .build()
    }

    fun getAppComponent(): AppComponent = appComponent

    companion object {
        fun get(context: Context) = (context.applicationContext as HomeApplication).componentInjector
    }
}
