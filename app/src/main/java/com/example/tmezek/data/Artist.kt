package com.example.tmezek.data

    data class Artist(
        val id: String,
        val name: String,
        val bio: String?,
        val topSongs: List<Song> = emptyList(),
        val albums: List<Album> = emptyList(),
        val profilePicture: Int,
        var isFavorite: Boolean= false
    )
