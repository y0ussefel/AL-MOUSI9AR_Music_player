package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.Song
import com.example.tmezek.objects.FavoritesRepo


class ListSongsFragment : Fragment() {
    private lateinit var songsRc :RecyclerView
    private lateinit var adapter :SongLIstAdapter
    private lateinit var list : ArrayList<Song>
    private val favoriteSongs = arrayListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         list = arrayListOf(
                Song(id = "1", title = "Blinding Lights", artist = listOf("The Weeknd"), album = "After Hours", duration = 200, coverImage = R.drawable.cover, genre = "Synthwave", releaseDate = "2019-11-29",false),
                Song(id = "2", title = "Shape of You", artist = listOf("Ed Sheeran"), album = "Divide", duration = 234, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2017-01-06",false),
                Song(id = "3", title = "Levitating", artist = listOf("Dua Lipa", "DaBaby"), album = "Future Nostalgia", duration = 203, coverImage = R.drawable.cover, genre = "Disco-Pop", releaseDate = "2020-03-27",false),
                Song(id = "4", title = "Someone Like You", artist = listOf("Adele"), album = "21", duration = 285, coverImage = R.drawable.cover, genre = "Soul", releaseDate = "2011-01-24",false),
                Song(id = "5", title = "Hotel California", artist = listOf("Eagles"), album = "Hotel California", duration = 390, coverImage = R.drawable.cover, genre = "Classic Rock", releaseDate = "1976-12-08",false),

                Song(id = "6", title = "Bohemian Rhapsody", artist = listOf("Queen"), album = "A Night at the Opera", duration = 354, coverImage = R.drawable.cover, genre = "Rock", releaseDate = "1975-10-31",false),
                Song(id = "7", title = "Like a Rolling Stone", artist = listOf("Bob Dylan"), album = "Highway 61 Revisited", duration = 368, coverImage = R.drawable.cover, genre = "Folk Rock", releaseDate = "1965-07-20",false),
                Song(id = "8", title = "Stairway to Heaven", artist = listOf("Led Zeppelin"), album = "Led Zeppelin IV", duration = 482, coverImage = R.drawable.cover, genre = "Hard Rock", releaseDate = "1971-11-08",false),
                Song(id = "9", title = "Billie Jean", artist = listOf("Michael Jackson"), album = "Thriller", duration = 294, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "1982-11-30",false),
                Song(id = "10", title = "Smells Like Teen Spirit", artist = listOf("Nirvana"), album = "Nevermind", duration = 301, coverImage = R.drawable.cover, genre = "Grunge", releaseDate = "1991-09-10",false),
                Song(id = "11", title = "Hey Jude", artist = listOf("The Beatles"), album = "Hey Jude", duration = 431, coverImage = R.drawable.cover, genre = "Rock", releaseDate = "1968-08-26",false),
                Song(id = "12", title = "Hallelujah", artist = listOf("Leonard Cohen"), album = "Various Positions", duration = 300, coverImage = R.drawable.cover, genre = "Folk", releaseDate = "1984-12-01",false),
                Song(id = "13", title = "Imagine", artist = listOf("John Lennon"), album = "Imagine", duration = 187, coverImage = R.drawable.cover, genre = "Rock", releaseDate = "1971-10-08",false),
                Song(id = "14", title = "One Dance", artist = listOf("Drake", "Wizkid", "Kyla"), album = "Views", duration = 173, coverImage = R.drawable.cover, genre = "Dancehall", releaseDate = "2016-04-05",false),
                Song(id = "15", title = "Rolling in the Deep", artist = listOf("Adele"), album = "21", duration = 228, coverImage = R.drawable.cover, genre = "Pop Soul", releaseDate = "2010-11-29",false)
                )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_list_songs, container, false)

        songsRc = view.findViewById(R.id.songListRv)
        songsRc.layoutManager = LinearLayoutManager(context)
        adapter = SongLIstAdapter(list){ song ->
            handleFavoriteClick(song)
        }
        songsRc.adapter  =adapter

        return view
    }

    private fun handleFavoriteClick(song: Song) {
        if (song.isFavorite) {
            FavoritesRepo.addFavoriteSong(song)
        } else {
            FavoritesRepo.removeFavoriteSong(song)
        }
        adapter.notifyDataSetChanged()
    }

    fun getFavoriteSongs(): ArrayList<Song> {
        return favoriteSongs
    }


}