package ru.sport.home.dagger

import dagger.Component
import ru.sport.common.utils.ContextProvider
import ru.sport.common.utils.ResourcesProvider
import ru.sport.home.HomeApplication
import javax.inject.Singleton

@Component(modules = [AppModule::class],
    dependencies = [ContextProvider::class])
@Singleton
interface AppComponent {
    fun inject(app: HomeApplication)

    fun resourceProvider(): ResourcesProvider
}

