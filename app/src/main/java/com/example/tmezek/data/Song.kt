package com.example.tmezek.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Song(
    val id: String,
    val title: String,
    val artist: List<String>, // Allows for collaborations
    val album: String?,
    val duration: Int, // In seconds
    val coverImage: Int, // URL or local resource
    val genre: String?,
    val releaseDate: String?, // Optional release date
    var isFavorite : Boolean= false
): Parcelable
