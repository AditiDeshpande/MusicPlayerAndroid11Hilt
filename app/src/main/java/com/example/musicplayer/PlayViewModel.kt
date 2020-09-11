package com.example.musicplayer

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.*

class PlayViewModel @ViewModelInject constructor(
@Assisted val savedStateHandle: SavedStateHandle ,
val db: MusicDatabase,
): ViewModel {
}