package com.example.musicplayer

import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
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
}