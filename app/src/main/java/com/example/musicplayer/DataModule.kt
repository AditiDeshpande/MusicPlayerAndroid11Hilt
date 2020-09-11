package com.example.musicplayer

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

class DataModule {
}

/*
ApplicationComponent denotes module will be available throughout
the application
 */
@Module
@InstallIn(ApplicationComponent::class)
object DataModule{

    @Provides
    @Singleton
    /*
    Why singleton we r sending DataBase as a param to multiple
    activities so it will create / have multiple instances of DB
    which is wrong we need to share same DB with all
     */
    fun provideMusicDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MusicDatabase::class.java , "music.db")
            .build()
}
