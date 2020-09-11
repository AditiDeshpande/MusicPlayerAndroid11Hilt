package com.example.musicplayer

import android.content.ContentProvider
import android.database.Cursor
import android.net.Uri
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent


/*
Hilt comes with AndroidX extensions
 */
class PlaylistContentProvider: ContentProvider() {
    @EntryPoint
    @InstallIn(ApplicationComponent::class)
    interface PlaylistCPEntryPoint {
        fun getMusicDatabase(): MusicDatabase
    }

    override fun query(...): {
        //EntryPointAccessors is a utility method
        val entryPoint = EntryPointAccessors.fromApplication(
            context ,
            PlaylistCPEntryPoint::class.java
        )
        val database = entryPoint.getMusicDatabase()
    }


}