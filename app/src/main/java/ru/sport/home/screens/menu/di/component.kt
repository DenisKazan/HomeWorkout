package ru.sport.home.screens.menu.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import dagger.*
import dagger.multibindings.IntoMap
import ru.sport.common.scopes.ActivityScope
import ru.sport.common.scopes.ViewModelKey
import ru.sport.home.dagger.AppComponent
import ru.sport.home.dagger.appComponent
import ru.sport.home.database.AppDatabase
import ru.sport.home.database.ExerciseDao
import ru.sport.home.screens.menu.IMenuRouter
import ru.sport.home.screens.menu.MenuActivity
import ru.sport.home.screens.menu.MenuRouter
import ru.sport.home.screens.menu.MenuViewModel

@Component(dependencies = [AppComponent::class], modules = [ExerciseTypeModule::class])
@ActivityScope
interface ExerciseTypeComponent {

    fun inject(activity: MenuActivity)

    companion object {
        fun init(appCompatActivity: AppCompatActivity): ExerciseTypeComponent =
            DaggerExerciseTypeComponent.builder()
                .appComponent(appCompatActivity.appComponent)
                .appCompatActivity(appCompatActivity)
                .build()
    }

    @Component.Builder
    interface Builder {
        fun build(): ExerciseTypeComponent
        fun appComponent(appComponent: AppComponent): Builder
        @BindsInstance
        fun appCompatActivity(appCompatActivity: AppCompatActivity): Builder

    }
}

@Module
abstract class ExerciseTypeModule {

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindViewModel(viewModel: MenuViewModel): ViewModel

    @Binds
    abstract fun bindRouter(router: MenuRouter): IMenuRouter

    @Module
    companion object {
        @Provides
        fun provideDao(appDatabase: AppDatabase): ExerciseDao = appDatabase.exerciseDao()
    }
}
