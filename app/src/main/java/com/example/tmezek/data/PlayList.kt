package com.example.tmezek.data
import android.os.Parcelable
import com.example.tmezek.R
import kotlinx.parcelize.Parcelize

data class PlayList(
    var id: String,
    val name: String,
    val description: String,
    val coverImage: Int,
    val songs: MutableList<Song>
){
    constructor(id: String,name: String,description: String):this(id, name, description, R.drawable.cover6, mutableListOf())
}