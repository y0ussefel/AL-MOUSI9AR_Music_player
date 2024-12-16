package com.example.tmezek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.ArtistLIstAdapter
import com.example.tmezek.data.Album
import com.example.tmezek.data.Artist
import com.example.tmezek.data.Song
import com.example.tmezek.objects.FavoritesRepo

/**
 * A simple [Fragment] subclass.
 * Use the [ListArtistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListArtistFragment : Fragment() {
    private lateinit var artistRc : RecyclerView
    private lateinit var adapter : ArtistLIstAdapter
    private lateinit var list : ArrayList<Artist>
    private lateinit var grod:GridLayoutManager
    private val favoriteArtist = arrayListOf<Artist>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         list = arrayListOf(
            Artist(
                id = "1",
                name = "The Weeknd",
                bio = "Abel Makkonen Tesfaye, known as The Weeknd, is a Canadian singer and songwriter.",
                topSongs = listOf(
                    Song(id = "1", title = "Blinding Lights", artist = listOf("The Weeknd"), album = "After Hours", duration = 200, coverImage = R.drawable.cover, genre = "Synthwave", releaseDate = "2019-11-29"),
                    Song(id = "2", title = "Save Your Tears", artist = listOf("The Weeknd"), album = "After Hours", duration = 215, coverImage = R.drawable.cover, genre = "Synthwave", releaseDate = "2020-08-09")
                ),
                albums = listOf(
                    Album(id = "1", title = "After Hours", artist = "The Weeknd", releaseDate = "2020", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.the_weekend
            ),
            Artist(
                id = "2",
                name = "Ava Max",
                bio = "Amanda Ava Koci, known professionally as Ava Max, is an American singer and songwriter.",
                topSongs = listOf(
                    Song(id = "3", title = "Sweet but Psycho", artist = listOf("Ava Max"), album = "Heaven & Hell", duration = 187, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2018-08-17"),
                    Song(id = "4", title = "Kings & Queens", artist = listOf("Ava Max"), album = "Heaven & Hell", duration = 178, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2020-03-12")
                ),
                albums = listOf(
                    Album(id = "2", title = "Heaven & Hell", artist = "Ava Max", releaseDate = "2020", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.ava_max
            ),
            Artist(
                id = "3",
                name = "Ed Sheeran",
                bio = "Edward Christopher Sheeran is an English singer-songwriter known for his soulful ballads.",
                topSongs = listOf(
                    Song(id = "5", title = "Shape of You", artist = listOf("Ed Sheeran"), album = "Divide", duration = 234, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2017-01-06"),
                    Song(id = "6", title = "Perfect", artist = listOf("Ed Sheeran"), album = "Divide", duration = 263, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2017-03-03")
                ),
                albums = listOf(
                    Album(id = "3", title = "Divide", artist = "Ed Sheeran", releaseDate = "2017", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.the_weekend
            ),
            Artist(
                id = "4",
                name = "Dua Lipa",
                bio = "Dua Lipa is an English-Albanian singer known for her signature disco-pop sound.",
                topSongs = listOf(
                    Song(id = "7", title = "Levitating", artist = listOf("Dua Lipa", "DaBaby"), album = "Future Nostalgia", duration = 203, coverImage = R.drawable.cover, genre = "Disco-Pop", releaseDate = "2020-03-27"),
                    Song(id = "8", title = "Don't Start Now", artist = listOf("Dua Lipa"), album = "Future Nostalgia", duration = 183, coverImage = R.drawable.cover, genre = "Disco-Pop", releaseDate = "2019-11-01")
                ),
                albums = listOf(
                    Album(id = "4", title = "Future Nostalgia", artist = "Dua Lipa", releaseDate = "2020", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.ava_max
            ),
            Artist(
                id = "5",
                name = "Adele",
                bio = "Adele Laurie Blue Adkins is an English singer-songwriter known for her powerful voice.",
                topSongs = listOf(
                    Song(id = "9", title = "Someone Like You", artist = listOf("Adele"), album = "21", duration = 285, coverImage = R.drawable.cover, genre = "Soul", releaseDate = "2011-01-24"),
                    Song(id = "10", title = "Rolling in the Deep", artist = listOf("Adele"), album = "21", duration = 228, coverImage = R.drawable.cover, genre = "Pop Soul", releaseDate = "2010-11-29")
                ),
                albums = listOf(
                    Album(id = "5", title = "21", artist = "Adele", releaseDate = "2011", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.ava_max
            ),
            Artist(
                id = "6",
                name = "Drake",
                bio = "Aubrey Drake Graham is a Canadian rapper, singer, and actor.",
                topSongs = listOf(
                    Song(id = "11", title = "Hotline Bling", artist = listOf("Drake"), album = "Views", duration = 267, coverImage = R.drawable.cover, genre = "R&B", releaseDate = "2015-07-31"),
                    Song(id = "12", title = "One Dance", artist = listOf("Drake", "Wizkid", "Kyla"), album = "Views", duration = 173, coverImage = R.drawable.cover, genre = "Dancehall", releaseDate = "2016-04-05")
                ),
                albums = listOf(
                    Album(id = "6", title = "Views", artist = "Drake", releaseDate = "2016", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.the_weekend
            ),
            Artist(
                id = "7",
                name = "Beyoncé",
                bio = "Beyoncé Giselle Knowles-Carter is an American singer, songwriter, and actress.",
                topSongs = listOf(
                    Song(id = "13", title = "Halo", artist = listOf("Beyoncé"), album = "I Am... Sasha Fierce", duration = 261, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2008-01-20"),
                    Song(id = "14", title = "Single Ladies", artist = listOf("Beyoncé"), album = "I Am... Sasha Fierce", duration = 197, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2008-10-08")
                ),
                albums = listOf(
                    Album(id = "7", title = "I Am... Sasha Fierce", artist = "Beyoncé", releaseDate = "2008", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.ava_max
            ),
            Artist(
                id = "8",
                name = "Bruno Mars",
                bio = "Peter Gene Hernandez, known as Bruno Mars, is an American singer-songwriter.",
                topSongs = listOf(
                    Song(id = "15", title = "Uptown Funk", artist = listOf("Bruno Mars", "Mark Ronson"), album = "Uptown Special", duration = 269, coverImage = R.drawable.cover, genre = "Funk", releaseDate = "2014-11-10"),
                    Song(id = "16", title = "Just the Way You Are", artist = listOf("Bruno Mars"), album = "Doo-Wops & Hooligans", duration = 220, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2010-07-20")
                ),
                albums = listOf(
                    Album(id = "8", title = "Doo-Wops & Hooligans", artist = "Bruno Mars", releaseDate = "2010", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.the_weekend
            ),
            Artist(
                id = "9",
                name = "Taylor Swift",
                bio = "Taylor Alison Swift is an American singer-songwriter known for her narrative songwriting.",
                topSongs = listOf(
                    Song(id = "17", title = "Love Story", artist = listOf("Taylor Swift"), album = "Fearless", duration = 238, coverImage = R.drawable.cover, genre = "Country Pop", releaseDate = "2008-09-15"),
                    Song(id = "18", title = "Blank Space", artist = listOf("Taylor Swift"), album = "1989", duration = 231, coverImage = R.drawable.cover, genre = "Synth-Pop", releaseDate = "2014-11-10")
                ),
                albums = listOf(
                    Album(id = "9", title = "Fearless", artist = "Taylor Swift", releaseDate = "2008", coverImage = R.drawable.cover)
                ),
                profilePicture = R.drawable.ava_max
            ))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list_artist, container, false)

        artistRc = view.findViewById(R.id.artistListRv)

        artistRc.layoutManager=LinearLayoutManager(context)
        adapter = ArtistLIstAdapter(list){artist ->
            handleFavoriteClick(artist)
        }
        artistRc.adapter = adapter

        return view
    }
    private fun handleFavoriteClick(artist: Artist) {
        if (artist.isFavorite) {
            FavoritesRepo.addFavoriteArtist(artist)
        } else {
            FavoritesRepo.removeFavoriteArtist(artist)
        }
        adapter.notifyDataSetChanged()
    }

    fun getFavoriteSongs(): ArrayList<Artist> {
        return favoriteArtist
    }




}