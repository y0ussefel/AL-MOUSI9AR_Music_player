package com.example.tmezek.objects

import com.example.tmezek.data.PlayList

object PlaylistRepo {
    private val playlists = mutableListOf<PlayList>()

    fun addPlaylist(playlist: PlayList) {
        playlists.add(playlist)
    }

    fun removePlaylist(playlist: PlayList) {
        playlists.remove(playlist)
    }

    fun getPlaylists(): List<PlayList> = playlists

    fun getPlaylistById(id: String): PlayList? {
        return playlists.find { it.id == id }
    }
}