package com.example.tmezek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.PlayList

class PlaylistDetailFragment : Fragment() {
    private lateinit var playlist: PlayList
    private lateinit var adapter: SongLIstAdapter

    companion object {
        private const val ARG_PLAYLIST = "playlist"

        fun newInstance(playlist: PlayList): PlaylistDetailFragment {
            val fragment = PlaylistDetailFragment()
            val args = Bundle().apply {
                putParcelable(ARG_PLAYLIST, playlist) // Ensure PlayList implements Parcelable
            }
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            playlist = it.getParcelable(ARG_PLAYLIST) ?: throw IllegalArgumentException("Missing playlist")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playlist_detail, container, false)

        val playlistName = view.findViewById<TextView>(R.id.playlistName)
        val playlistDescription = view.findViewById<TextView>(R.id.playlistDescription)
        val songRecyclerView = view.findViewById<RecyclerView>(R.id.songRecyclerView)

        playlistName.text = playlist.name
        playlistDescription.text = playlist.description ?: "No description"

        songRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = SongLIstAdapter(ArrayList(playlist.songs)) { /* Handle song clicks if needed */ }
        songRecyclerView.adapter = adapter

        return view
    }

    fun setPlaylist(playlist: PlayList) {
        this.playlist = playlist
    }
}
