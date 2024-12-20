package com.example.tmezek.fragments


import PlayerFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.ForYouAdapter
import com.example.tmezek.adapters.PopularAdapter
import com.example.tmezek.adapters.TrendingViewHolder
import com.example.tmezek.data.Song

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Activities.newInstance] factory method to
 * create an instance of this fragment.
 */
class Activities : Fragment() {

    private lateinit var trendingRc :RecyclerView
    private lateinit var populerRc :RecyclerView
    private lateinit var forYouRc :RecyclerView
    private lateinit var adapterTR : TrendingViewHolder
    private lateinit var adapterPP : PopularAdapter
    private lateinit var adapterFR : ForYouAdapter


    private var listTrending: ArrayList<Song> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listTrending = arrayListOf(
            Song(id = "1", title = "Blinding Lights", artist = listOf("The Weeknd"), album = "After Hours", duration = 200000, coverImage = R.drawable.cover, genre = "Synthwave", releaseDate = "2019-11-29", isFavorite = false),
            Song(id = "2", title = "Shape of You", artist = listOf("Ed Sheeran"), album = "Divide", duration = 234000, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2017-01-06", isFavorite = false),
            Song(id = "3", title = "Levitating", artist = listOf("Dua Lipa", "DaBaby"), album = "Future Nostalgia", duration = 203000, coverImage = R.drawable.cover, genre = "Disco-Pop", releaseDate = "2020-03-27", isFavorite = false),
            Song(id = "4", title = "Someone Like You", artist = listOf("Adele"), album = "21", duration = 285000, coverImage = R.drawable.cover, genre = "Soul", releaseDate = "2011-01-24", isFavorite = false),
            Song(id = "5", title = "Hotel California", artist = listOf("Eagles"), album = "Hotel California", duration = 390000, coverImage = R.drawable.cover, genre = "Classic Rock", releaseDate = "1976-12-08", isFavorite = false),
            Song(id = "6", title = "Bohemian Rhapsody", artist = listOf("Queen"), album = "A Night at the Opera", duration = 354000, coverImage = R.drawable.cover, genre = "Rock", releaseDate = "1975-10-31", isFavorite = false),
            Song(id = "7", title = "Like a Rolling Stone", artist = listOf("Bob Dylan"), album = "Highway 61 Revisited", duration = 368000, coverImage = R.drawable.cover, genre = "Folk Rock", releaseDate = "1965-07-20", isFavorite = false),
            Song(id = "8", title = "Stairway to Heaven", artist = listOf("Led Zeppelin"), album = "Led Zeppelin IV", duration = 482000, coverImage = R.drawable.cover, genre = "Hard Rock", releaseDate = "1971-11-08", isFavorite = false),
            Song(id = "9", title = "Billie Jean", artist = listOf("Michael Jackson"), album = "Thriller", duration = 294000, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "1982-11-30", isFavorite = false),
            Song(id = "10", title = "Smells Like Teen Spirit", artist = listOf("Nirvana"), album = "Nevermind", duration = 301000, coverImage = R.drawable.cover, genre = "Grunge", releaseDate = "1991-09-10", isFavorite = false),
            Song(id = "11", title = "Hey Jude", artist = listOf("The Beatles"), album = "Hey Jude", duration = 431000, coverImage = R.drawable.cover, genre = "Rock", releaseDate = "1968-08-26", isFavorite = false),
            Song(id = "12", title = "Hallelujah", artist = listOf("Leonard Cohen"), album = "Various Positions", duration = 300000, coverImage = R.drawable.cover, genre = "Folk", releaseDate = "1984-12-01", isFavorite = false),
            Song(id = "13", title = "Imagine", artist = listOf("John Lennon"), album = "Imagine", duration = 187000, coverImage = R.drawable.cover, genre = "Rock", releaseDate = "1971-10-08", isFavorite = false),
            Song(id = "14", title = "One Dance", artist = listOf("Drake", "Wizkid", "Kyla"), album = "Views", duration = 173000, coverImage = R.drawable.cover, genre = "Dancehall", releaseDate = "2016-04-05", isFavorite = false),
            Song(id = "15", title = "Rolling in the Deep", artist = listOf("Adele"), album = "21", duration = 228000, coverImage = R.drawable.cover, genre = "Pop Soul", releaseDate = "2010-11-29", isFavorite = false)
        )


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_activities, container, false)

        trendingRc = view.findViewById(R.id.trendingRecycler)

        trendingRc.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        adapterTR = TrendingViewHolder(listTrending)
        trendingRc.adapter = adapterTR

        populerRc = view.findViewById(R.id.popularRv)
        populerRc.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        adapterPP = PopularAdapter(listTrending) {song->
            openPlayerFragment(song)
        }
        populerRc.adapter = adapterPP

        forYouRc = view.findViewById(R.id.forYouRv)
        forYouRc.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        adapterFR = ForYouAdapter(listTrending)
        forYouRc.adapter = adapterFR
        return view

    }
    private fun openPlayerFragment(song: Song) {
        val fragment = PlayerFragment()
        val bundle = Bundle().apply {
            putParcelable("song", song) // Pass the full song list
        // Pass the selected song index
        }
        fragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fl, fragment) // Ensure correct container ID
            .addToBackStack(null)
            .commit()
    }



}