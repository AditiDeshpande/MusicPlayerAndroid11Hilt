package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlayActivity : AppCompatActivity() {

    @Inject
    lateinit var player: MusicPlayer

    val viewModel: PlayViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //player.play("Asha Bhosale")
        viewModel.play("Asha Bhosale")
    }
}