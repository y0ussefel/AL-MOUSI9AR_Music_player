package com.example.tmezek.data

data class Genre(
    val id: String,
    val name: String,
    val description: String?,
    var isSelected: Boolean = false,
    val coverImage: Int? // Optional image representing the genre
)
