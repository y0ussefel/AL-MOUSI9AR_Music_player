package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.AlbumListAdaper
import com.example.tmezek.adapters.ArtistLIstAdapter
import com.example.tmezek.data.Album
import com.example.tmezek.data.Artist

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListAlbumFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListAlbumFragment : Fragment() {
    private lateinit var albumRc : RecyclerView
    private lateinit var adapter : AlbumListAdaper
    private  lateinit var list : ArrayList<Album>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         list = arrayListOf(
            Album(id = "1", title = "After Hours", artist = "The Weeknd", releaseDate = "2020", coverImage = R.drawable.cover1),
            Album(id = "2", title = "Future Nostalgia", artist = "Dua Lipa", releaseDate = "2020", coverImage = R.drawable.cover2),
            Album(id = "3", title = "Divide", artist = "Ed Sheeran", releaseDate = "2017", coverImage = R.drawable.cover3),
            Album(id = "4", title = "21", artist = "Adele", releaseDate = "2011", coverImage = R.drawable.cover4),
            Album(id = "5", title = "Thriller", artist = "Michael Jackson", releaseDate = "1982", coverImage = R.drawable.cover5),
            Album(id = "6", title = "Nevermind", artist = "Nirvana", releaseDate = "1991", coverImage = R.drawable.cover6),
            Album(id = "7", title = "Abbey Road", artist = "The Beatles", releaseDate = "1969", coverImage = R.drawable.cover1),
            Album(id = "8", title = "Rumours", artist = "Fleetwood Mac", releaseDate = "1977", coverImage = R.drawable.cover2),
            Album(id = "9", title = "Back to Black", artist = "Amy Winehouse", releaseDate = "2006", coverImage = R.drawable.cover3),
            Album(id = "10", title = "Hotel California", artist = "Eagles", releaseDate = "1976", coverImage = R.drawable.cover4),
            Album(id = "11", title = "The Dark Side of the Moon", artist = "Pink Floyd", releaseDate = "1973", coverImage = R.drawable.cover5),
            Album(id = "12", title = "Born to Run", artist = "Bruce Springsteen", releaseDate = "1975", coverImage = R.drawable.cover6),
            Album(id = "13", title = "Like a Prayer", artist = "Madonna", releaseDate = "1989", coverImage = R.drawable.cover1),
            Album(id = "14", title = "Purple Rain", artist = "Prince", releaseDate = "1984", coverImage = R.drawable.cover2),
            Album(id = "15", title = "Appetite for Destruction", artist = "Guns N' Roses", releaseDate = "1987", coverImage = R.drawable.cover3)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_list_album, container, false)
          albumRc = view.findViewById(R.id.albumListRv)
        albumRc.layoutManager = GridLayoutManager(context,2)
        adapter = AlbumListAdaper(list,parentFragmentManager)
        albumRc.adapter = adapter

        val bundle = Bundle()

        return view
    }


}