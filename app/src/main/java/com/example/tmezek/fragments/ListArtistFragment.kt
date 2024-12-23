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
                profilePicture = R.drawable.art1
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
                profilePicture = R.drawable.art2
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
                profilePicture = R.drawable.art3
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
                profilePicture = R.drawable.art4
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
                profilePicture = R.drawable.art5
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
                profilePicture = R.drawable.art6
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
                profilePicture = R.drawable.art7
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
                profilePicture = R.drawable.art8
            ),Artist(id = "10", name = "Ed Sheeran", bio = "Edward Christopher Sheeran is an English singer-songwriter and musician.", topSongs = listOf(Song(id = "2", title = "Shape of You", artist = listOf("Ed Sheeran"), album = "Divide", duration = 234, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2017-01-06")), albums = listOf(Album(id = "10", title = "Divide", artist = "Ed Sheeran", releaseDate = "2017", coverImage = R.drawable.cover)), profilePicture = R.drawable.art9),
             Artist(id = "11", name = "Adele", bio = "Adele Laurie Blue Adkins is an English singer-songwriter known for her powerful vocals.", topSongs = listOf(Song(id = "4", title = "Someone Like You", artist = listOf("Adele"), album = "21", duration = 285, coverImage = R.drawable.cover, genre = "Soul", releaseDate = "2011-01-24")), albums = listOf(Album(id = "11", title = "21", artist = "Adele", releaseDate = "2011", coverImage = R.drawable.cover)), profilePicture = R.drawable.art10),
             Artist(id = "12", name = "The Weeknd", bio = "Abel Makkonen Tesfaye, known professionally as The Weeknd, is a Canadian singer-songwriter.", topSongs = listOf(Song(id = "1", title = "Blinding Lights", artist = listOf("The Weeknd"), album = "After Hours", duration = 200, coverImage = R.drawable.cover, genre = "Synthwave", releaseDate = "2019-11-29")), albums = listOf(Album(id = "12", title = "After Hours", artist = "The Weeknd", releaseDate = "2020", coverImage = R.drawable.cover)), profilePicture = R.drawable.art11),
             Artist(id = "13", name = "Dua Lipa", bio = "Dua Lipa is an English singer-songwriter known for her modern pop and disco-inspired music.", topSongs = listOf(Song(id = "3", title = "Levitating", artist = listOf("Dua Lipa", "DaBaby"), album = "Future Nostalgia", duration = 203, coverImage = R.drawable.cover, genre = "Disco-Pop", releaseDate = "2020-03-27")), albums = listOf(Album(id = "13", title = "Future Nostalgia", artist = "Dua Lipa", releaseDate = "2020", coverImage = R.drawable.cover)), profilePicture = R.drawable.art12),
             Artist(id = "14", name = "Michael Jackson", bio = "Michael Joseph Jackson was an American singer, songwriter, and dancer, dubbed the 'King of Pop'.", topSongs = listOf(Song(id = "9", title = "Billie Jean", artist = listOf("Michael Jackson"), album = "Thriller", duration = 294, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "1982-11-30")), albums = listOf(Album(id = "14", title = "Thriller", artist = "Michael Jackson", releaseDate = "1982", coverImage = R.drawable.cover)), profilePicture = R.drawable.art13),
             Artist(id = "15", name = "Nirvana", bio = "Nirvana was an American rock band formed in Aberdeen, Washington, known for their grunge sound.", topSongs = listOf(Song(id = "10", title = "Smells Like Teen Spirit", artist = listOf("Nirvana"), album = "Nevermind", duration = 301, coverImage = R.drawable.cover, genre = "Grunge", releaseDate = "1991-09-10")), albums = listOf(Album(id = "15", title = "Nevermind", artist = "Nirvana", releaseDate = "1991", coverImage = R.drawable.cover)), profilePicture = R.drawable.art14),
             Artist(id = "16", name = "Queen", bio = "Queen is a British rock band formed in London in 1970, known for their elaborate and eclectic style.", topSongs = listOf(Song(id = "6", title = "Bohemian Rhapsody", artist = listOf("Queen"), album = "A Night at the Opera", duration = 354, coverImage = R.drawable.cover, genre = "Rock", releaseDate = "1975-10-31")), albums = listOf(Album(id = "16", title = "A Night at the Opera", artist = "Queen", releaseDate = "1975", coverImage = R.drawable.cover)), profilePicture = R.drawable.art15),
             Artist(id = "17", name = "The Beatles", bio = "The Beatles were an English rock band formed in Liverpool, widely regarded as the most influential band.", topSongs = listOf(Song(id = "11", title = "Hey Jude", artist = listOf("The Beatles"), album = "Hey Jude", duration = 431, coverImage = R.drawable.cover, genre = "Rock", releaseDate = "1968-08-26")), albums = listOf(Album(id = "17", title = "Abbey Road", artist = "The Beatles", releaseDate = "1969", coverImage = R.drawable.cover)), profilePicture = R.drawable.art16),
             Artist(id = "18", name = "Amy Winehouse", bio = "Amy Jade Winehouse was an English singer-songwriter known for her deep, expressive vocals.", topSongs = listOf(Song(id = "8", title = "Back to Black", artist = listOf("Amy Winehouse"), album = "Back to Black", duration = 295, coverImage = R.drawable.cover, genre = "Soul", releaseDate = "2006-10-27")), albums = listOf(Album(id = "18", title = "Back to Black", artist = "Amy Winehouse", releaseDate = "2006", coverImage = R.drawable.cover)), profilePicture = R.drawable.art17),
             Artist(id = "19", name = "Kendrick Lamar", bio = "Kendrick Lamar is an American rapper, songwriter, and record producer known for his profound lyrics.", topSongs = listOf(Song(id = "19", title = "Alright", artist = listOf("Kendrick Lamar"), album = "To Pimp a Butterfly", duration = 235, coverImage = R.drawable.cover, genre = "Hip Hop", releaseDate = "2015-03-15")), albums = listOf(Album(id = "19", title = "To Pimp a Butterfly", artist = "Kendrick Lamar", releaseDate = "2015", coverImage = R.drawable.cover)), profilePicture = R.drawable.art18),
             Artist(id = "20", name = "Beyoncé", bio = "Beyoncé Giselle Knowles-Carter is an American singer, songwriter, and actress.", topSongs = listOf(Song(id = "20", title = "Halo", artist = listOf("Beyoncé"), album = "I Am... Sasha Fierce", duration = 261, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2008-01-20")), albums = listOf(Album(id = "20", title = "Lemonade", artist = "Beyoncé", releaseDate = "2016", coverImage = R.drawable.cover)), profilePicture = R.drawable.art19),
             Artist(id = "21", name = "Bruno Mars", bio = "Peter Gene Hernandez, known professionally as Bruno Mars, is an American singer-songwriter and producer.", topSongs = listOf(Song(id = "21", title = "Uptown Funk", artist = listOf("Bruno Mars"), album = "Uptown Special", duration = 269, coverImage = R.drawable.cover, genre = "Funk", releaseDate = "2014-11-10")), albums = listOf(Album(id = "21", title = "24K Magic", artist = "Bruno Mars", releaseDate = "2016", coverImage = R.drawable.cover)), profilePicture = R.drawable.art20)

         )
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