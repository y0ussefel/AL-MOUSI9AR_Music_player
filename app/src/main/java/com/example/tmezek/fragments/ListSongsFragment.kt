package com.example.tmezek.fragments

import android.os.Bundle
import android.view.GestureDetector
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.Song
import com.example.tmezek.objects.FavoritesRepo
import com.example.tmezek.objects.Songs


class ListSongsFragment : Fragment() {
    private lateinit var songsRc :RecyclerView
    private lateinit var adapter :SongLIstAdapter
     lateinit var list : ArrayList<Song>
    private val favoriteSongs = arrayListOf<Song>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         list = ArrayList(Songs.getSongs())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_list_songs, container, false)

        songsRc = view.findViewById(R.id.songListRv)
        songsRc.layoutManager = LinearLayoutManager(context)
        adapter = SongLIstAdapter(list, false, { song ->
            handleFavoriteClick(song)
        })
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