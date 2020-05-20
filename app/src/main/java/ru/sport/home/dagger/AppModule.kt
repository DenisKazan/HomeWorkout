package ru.sport.home.dagger

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.sport.home.database.AppDatabase
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideDb(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .build()
}
