package com.example.tmezek.data

data class Library(
    val playlists: List<PlayList> = emptyList(),
    val favorites: List<Song> = emptyList(), // Stores user favorites
    val recentSongs: List<Song> = emptyList()
)
