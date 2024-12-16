package com.example.tmezek.objects

import com.example.tmezek.data.Artist
import com.example.tmezek.data.Song

object FavoritesRepo {
    private val favoriteSongs = mutableListOf<Song>()
    private val favoriteArtists = mutableListOf<Artist>()

    fun addFavoriteSong(song: Song) {
        if (!favoriteSongs.contains(song)) favoriteSongs.add(song)
    }

    fun removeFavoriteSong(song: Song) {
        favoriteSongs.remove(song)
    }

    fun getFavoriteSongs(): List<Song> = favoriteSongs

    fun addFavoriteArtist(artist: Artist) {
        if (!favoriteArtists.contains(artist)) favoriteArtists.add(artist)
    }

    fun removeFavoriteArtist(artist: Artist) {
        favoriteArtists.remove(artist)
    }

    fun getFavoriteArtists(): List<Artist> = favoriteArtists
}