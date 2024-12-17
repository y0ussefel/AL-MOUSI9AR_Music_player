package com.example.tmezek.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class PlayList(
    val id: String,
    val name: String,
    val description: String?,
    val coverImage: Int?, // URL or local resource
    val songs: MutableList<Song>
)
