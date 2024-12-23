package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.AlbumSongsAdapter
import com.example.tmezek.objects.Songs
import kotlinx.coroutines.internal.artificialFrame

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AlbumSongs : Fragment() {
   private lateinit var adapter: AlbumSongsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleAlbum = view.findViewById<TextView>(R.id.albumName)
        val coverAlbum = view.findViewById<ImageView>(R.id.albumCover)

        val bundle = arguments
        if (bundle != null){
            val title = bundle.getString("titleAlbum")
            val cover = bundle.getInt("coverAlbum")

            titleAlbum.text = title
            coverAlbum.setImageResource(cover)

        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.albumSongsList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val list = ArrayList(Songs.getSongs())
        adapter = AlbumSongsAdapter(list)
        recyclerView.adapter = adapter

    }


}