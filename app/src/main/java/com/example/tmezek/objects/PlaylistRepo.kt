package com.example.tmezek.objects

import com.example.tmezek.data.PlayList
import com.example.tmezek.data.Song

object PlaylistRepo {
    private val playlists = mutableListOf<PlayList>()
    private var nextId = 1

    fun addPlaylist(playlist: PlayList): Boolean {
        playlist.id = nextId.toString()
        nextId++
        return playlists.add(playlist)
    }

    fun removePlaylist(playlist: PlayList) {
        playlists.remove(playlist)
    }

    fun findPosition(title: String): PlayList? {
        return playlists.find { it.name == title }
    }

    fun update(playlist: PlayList, song: Song): Boolean {
        val index = playlists.indexOfFirst { it.name == playlist.name }
        return if (index != -1 && !playlists[index].songs.contains(song)) {
            playlists[index].songs.add(song)
            true
        } else {
            false
        }
    }

    fun getPlaylists(): List<PlayList> = playlists

    fun getPlaylistById(id: String): PlayList? {
        return playlists.find { it.id == id }
    }
}