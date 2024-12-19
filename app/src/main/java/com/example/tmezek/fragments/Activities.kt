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


    private  var listTrending : ArrayList<Song> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         listTrending = arrayListOf(
            Song(id = "1", title = "Blinding Lights", artist = listOf("The Weeknd"), album = "After Hours", duration = 200, coverImage = R.drawable.cover, genre = "Synthwave", releaseDate = "2019-11-29"),
            Song(id = "2", title = "Shape of You", artist = listOf("Ed Sheeran"), album = "Divide", duration = 234, coverImage = R.drawable.cover, genre = "Pop", releaseDate = "2017-01-06"),
            Song(id = "3", title = "Levitating", artist = listOf("Dua Lipa", "DaBaby"), album = "Future Nostalgia", duration = 203, coverImage = R.drawable.cover, genre = "Disco-Pop", releaseDate = "2020-03-27"),
            Song(id = "4", title = "Someone Like You", artist = listOf("Adele"), album = "21", duration = 285, coverImage = R.drawable.cover, genre = "Soul", releaseDate = "2011-01-24"),
            Song(id = "5", title = "Hotel California", artist = listOf("Eagles"), album = "Hotel California", duration = 390, coverImage = R.drawable.cover, genre = "Classic Rock", releaseDate = "1976-12-08")
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
        adapterPP = PopularAdapter(listTrending){song ->
            openPlayerFragment(song)  }
        populerRc.adapter = adapterPP

        forYouRc = view.findViewById(R.id.forYouRv)
        forYouRc.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        adapterFR = ForYouAdapter(listTrending)
        forYouRc.adapter = adapterFR
        return view

    }
    private fun openPlayerFragment(song: Song) {
        val fragment = PlayerFragment() // Assuming `PlayerFragment` is your music player fragment
        val bundle = Bundle().apply {
            putParcelable("song", song) // Send the selected song
        }
        fragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fl, fragment) // Ensure the correct container ID
            .addToBackStack(null)
            .commit()
    }



}