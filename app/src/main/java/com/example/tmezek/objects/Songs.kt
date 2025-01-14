package com.example.tmezek.objects

import com.example.tmezek.R
import com.example.tmezek.data.Song


object Songs {
    val listSong = mutableListOf<Song>()
    private val songs = mutableListOf(
        Song(id = "1", title = "Blinding Lights", artist = listOf("The Weeknd"), album = "After Hours", duration = 200000, coverImage = R.drawable.song1, genre = "Synthwave", releaseDate = "2019-11-29", isFavorite = false),
        Song(id = "2", title = "Shape of You", artist = listOf("Ed Sheeran"), album = "Divide", duration = 234000, coverImage = R.drawable.song2, genre = "Pop", releaseDate = "2017-01-06", isFavorite = false),
        Song(id = "3", title = "Levitating", artist = listOf("Dua Lipa", "DaBaby"), album = "Future Nostalgia", duration = 203000, coverImage = R.drawable.cover, genre = "Disco-Pop", releaseDate = "2020-03-27", isFavorite = false),
        Song(id = "4", title = "Someone Like You", artist = listOf("Adele"), album = "21", duration = 285000, coverImage = R.drawable.song3, genre = "Soul", releaseDate = "2011-01-24", isFavorite = false),
        Song(id = "5", title = "Hotel California", artist = listOf("Eagles"), album = "Hotel California", duration = 390000, coverImage = R.drawable.song4, genre = "Classic Rock", releaseDate = "1976-12-08", isFavorite = false),
        Song(id = "6", title = "Bohemian Rhapsody", artist = listOf("Queen"), album = "A Night at the Opera", duration = 354000, coverImage = R.drawable.song5, genre = "Rock", releaseDate = "1975-10-31", isFavorite = false),
        Song(id = "7", title = "Like a Rolling Stone", artist = listOf("Bob Dylan"), album = "Highway 61 Revisited", duration = 368000, coverImage = R.drawable.song6, genre = "Folk Rock", releaseDate = "1965-07-20", isFavorite = false),
        Song(id = "8", title = "Stairway to Heaven", artist = listOf("Led Zeppelin"), album = "Led Zeppelin IV", duration = 482000, coverImage = R.drawable.song7, genre = "Hard Rock", releaseDate = "1971-11-08", isFavorite = false),
        Song(id = "9", title = "Billie Jean", artist = listOf("Michael Jackson"), album = "Thriller", duration = 294000, coverImage = R.drawable.song8, genre = "Pop", releaseDate = "1982-11-30", isFavorite = false),
        Song(id = "10", title = "Smells Like Teen Spirit", artist = listOf("Nirvana"), album = "Nevermind", duration = 301000, coverImage = R.drawable.song9, genre = "Grunge", releaseDate = "1991-09-10", isFavorite = false),
        Song(id = "11", title = "Hey Jude", artist = listOf("The Beatles"), album = "Hey Jude", duration = 431000, coverImage = R.drawable.song10, genre = "Rock", releaseDate = "1968-08-26", isFavorite = false),
        Song(id = "12", title = "Hallelujah", artist = listOf("Leonard Cohen"), album = "Various Positions", duration = 300000, coverImage = R.drawable.song11, genre = "Folk", releaseDate = "1984-12-01", isFavorite = false),
        Song(id = "13", title = "Imagine", artist = listOf("John Lennon"), album = "Imagine", duration = 187000, coverImage = R.drawable.song12, genre = "Rock", releaseDate = "1971-10-08", isFavorite = false),
        Song(id = "14", title = "One Dance", artist = listOf("Drake", "Wizkid", "Kyla"), album = "Views", duration = 173000, coverImage = R.drawable.song13, genre = "Dancehall", releaseDate = "2016-04-05", isFavorite = false),
        Song(id = "15", title = "Rolling in the Deep", artist = listOf("Adele"), album = "21", duration = 228000, coverImage = R.drawable.song14, genre = "Pop Soul", releaseDate = "2010-11-29", isFavorite = false),
        Song(id = "16", title = "Shake It Off", artist = listOf("Taylor Swift"), album = "1989", duration = 242000, coverImage = R.drawable.song15, genre = "Pop", releaseDate = "2014-08-18", isFavorite = false),
        Song(id = "17", title = "All of Me", artist = listOf("John Legend"), album = "Love in the Future", duration = 269000, coverImage = R.drawable.song16, genre = "Soul", releaseDate = "2013-08-12", isFavorite = false),
        Song(id = "18", title = "Thinking Out Loud", artist = listOf("Ed Sheeran"), album = "x", duration = 281000, coverImage = R.drawable.song17, genre = "Pop Soul", releaseDate = "2014-09-24", isFavorite = false),
        Song(id = "19", title = "Old Town Road", artist = listOf("Lil Nas X", "Billy Ray Cyrus"), album = "7", duration = 157000, coverImage = R.drawable.song18, genre = "Country Rap", releaseDate = "2019-03-14", isFavorite = false),
        Song(id = "20", title = "Uptown Funk", artist = listOf("Mark Ronson", "Bruno Mars"), album = "Uptown Special", duration = 269000, coverImage = R.drawable.song19, genre = "Funk", releaseDate = "2014-11-10", isFavorite = false),
        Song(id = "21", title = "Rolling in the Deep", artist = listOf("Adele"), album = "21", duration = 228000, coverImage = R.drawable.song20, genre = "Pop Soul", releaseDate = "2010-11-29", isFavorite = false)

    )


    fun addSong(song: Song) {
        songs.add(song)
    }
    fun addSongToPlayList(song: Song) {
        listSong.add(song)
    }
    fun clearSong() {
        listSong.clear()

    }

    fun removeSong(song: Song) {
        songs.remove(song)
    }

    fun getSongs(): List<Song> = songs
    fun getSongsList(): List<Song> = listSong
}