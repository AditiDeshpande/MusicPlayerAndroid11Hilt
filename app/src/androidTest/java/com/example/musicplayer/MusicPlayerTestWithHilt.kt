package com.example.musicplayer

import android.app.Application
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(DataModule::class)
@RunWith(AndroidJUnit4::class)
class MusicPlayerTestWithHilt {

    @get:Rule
    val rule = HiltAndroidRule(this)

    @Inject
    lateinit var player: MusicPlayer

    @Before
    fun setup(){
        //rule.inject(this)
        rule.inject()
    }

    @Test
    fun testPlay(){
        player.play("Asha Bhosale")
        assertTrue(player.isPlaying())
    }

    @Module
    @InstallIn(ApplicationComponent::class)
    object TestModule {
        @Provides
        fun provideDB(app: Application) =
            Room.inMemoryDatabaseBuilder(app ,
            MusicDatabase::class.java).build()
    }
}