package com.example.musicplayer

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MusicPlayerTest {

@Test
fun testPlay(){
    val db = Room.inMemoryDatabaseBuilder(
        InstrumentationRegistry.getInstrumentation().targetContext,
        MusicDatabase::class.java
    ).build()

    val player = MusicPlayer(db)
    player.play("Asha Bhosale")
    assertTrue(player.isPlaying())
}

}