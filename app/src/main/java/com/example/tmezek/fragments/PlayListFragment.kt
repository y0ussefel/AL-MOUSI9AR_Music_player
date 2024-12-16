package com.example.tmezek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.PlaylistAdapter
import com.example.tmezek.data.PlayList

class PlayListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlaylistAdapter
    private val playlists = mutableListOf<PlayList>() // Replace with actual data source.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Example playlists (Replace with actual data source or ViewModel logic)
        playlists.add(
            PlayList(
                id = "1",
                name = "Chill Vibes",
                description = "Relaxing songs to unwind",
                coverImage = R.drawable.cover5 ,
                songs = mutableListOf()
            )
        )
        playlists.add(
            PlayList(
                id = "2",
                name = "Workout Hits",
                description = "Energetic beats to power your workout",
                coverImage = R.drawable.cover2,
                songs = mutableListOf()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playlist, container, false)
        recyclerView = view.findViewById(R.id.playlistRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = PlaylistAdapter(playlists) { playlist ->
            navigateToPlaylistDetail(playlist)
        }
        recyclerView.adapter = adapter
        return view
    }

    private fun navigateToPlaylistDetail(playlist: PlayList) {
        val detailFragment = PlaylistDetailFragment.newInstance(playlist)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fl, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}
