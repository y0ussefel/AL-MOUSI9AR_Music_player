package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.GenreListAdapter
import com.example.tmezek.data.Genre

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListGenerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListGenerFragment : Fragment() {
    private lateinit var genreRc: RecyclerView
    private lateinit var genreAdapter: GenreListAdapter
    private lateinit var list : ArrayList<Genre>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        list = arrayListOf(

        Genre(id = "2", name = "Hip Hop/Rap", description = "Rhythmic music with spoken word.", coverImage = R.drawable.cover2, isSelected = false),
        Genre(id = "3", name = "R&B", description = "Rhythm and blues with soulful vocals.", coverImage = R.drawable.cover3, isSelected = false),
        Genre(id = "4", name = "Blues", description = "Melancholic music with origins in African American culture.", coverImage = R.drawable.cover4, isSelected = false),
        Genre(id = "5", name = "Latin", description = "Music with roots in Latin America.", coverImage = R.drawable.cover5, isSelected = false),
        Genre(id = "6", name = "Rock", description = "Genre with electric guitars and strong beats.", coverImage = R.drawable.cover6, isSelected = false),
        Genre(id = "7", name = "Country", description = "Music with acoustic instruments and storytelling.", coverImage = R.drawable.cover1, isSelected = false),
        Genre(id = "8", name = "Jazz", description = "Improvisational music with complex harmonies.", coverImage = R.drawable.cover2, isSelected = false),
        Genre(id = "9", name = "Electronic", description = "Music with synthesizers and electronic instruments.", coverImage = R.drawable.cover3, isSelected = false),
        Genre(id = "10", name = "Classical", description = "Traditional Western art music.", coverImage = R.drawable.cover4, isSelected = false),
        Genre(id = "11", name = "Soul/Funk", description = "Music with strong rhythm and soulful vocals.", coverImage = R.drawable.cover5, isSelected = false),
        Genre(id = "12", name = "Reggae", description = "Music with Jamaican roots and offbeat rhythms.", coverImage = R.drawable.cover6, isSelected = false),
        Genre(id = "13", name = "Indie", description = "Independent music with unique sounds.", coverImage = R.drawable.cover1, isSelected = false),
        Genre(id = "14", name = "Metal", description = "Heavy, distorted guitar music.", coverImage = R.drawable.cover2, isSelected = false),
        Genre(id = "15", name = "Folk", description = "Traditional music with acoustic instruments.", coverImage = R.drawable.cover3, isSelected = false),
        Genre(id = "16", name = "Dancehall", description = "Jamaican popular music with dance rhythm.", coverImage = R.drawable.cover4, isSelected = false),
        Genre(id = "17", name = "Gospel", description = "Religious music with vocals and harmonies.", coverImage = R.drawable.cover5, isSelected = false),
        Genre(id = "18", name = "Ambient", description = "Atmospheric music with electronic or acoustic sounds.", coverImage = R.drawable.cover6, isSelected = false),
        Genre(id = "19", name = "Punk", description = "Fast-paced, rebellious rock music.", coverImage = R.drawable.cover1, isSelected = false),
        Genre(id = "20", name = "World", description = "Music with traditional instruments and influences from across the globe.", coverImage = R.drawable.cover2, isSelected = false)
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_gener, container, false)
        genreRc = view.findViewById(R.id.genreRv)
        genreRc.layoutManager = GridLayoutManager(context, 3) // 3 columns
        genreAdapter = GenreListAdapter(list)


        genreRc.adapter = genreAdapter

        return view
    }
}


