    package com.example.tmezek.data

    data class Album(
        val id: String,
        val title: String,
        val artist:String, // Multiple artists for collaboration albums
        val releaseDate: String,
        val coverImage: Int,
        val songs: List<Song> = emptyList()
    )

