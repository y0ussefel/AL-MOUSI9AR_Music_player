package com.example.tmezek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.PlayList
import com.example.tmezek.data.Song
import com.example.tmezek.objects.FavoritesRepo

class PlaylistDialogFragment(private val onPlaylistCreated: (PlayList) -> Unit) : DialogFragment() {
    private lateinit var adapter: SongLIstAdapter
    private val selectedSongs = mutableListOf<Song>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_add_playlist, container, false)

        val playlistNameEt = view.findViewById<EditText>(R.id.playlistNameEt)
        val playlistDescriptionEt = view.findViewById<EditText>(R.id.playlistDescriptionEtt)
        val songSelectionRv = view.findViewById<RecyclerView>(R.id.songSelectionRv)
        val btnCreatePlaylist = view.findViewById<Button>(R.id.btnCreatePlaylist)

        songSelectionRv.layoutManager = LinearLayoutManager(context)
        adapter = SongLIstAdapter(getAllSongs()) { song ->
            if (selectedSongs.contains(song)) {
                selectedSongs.remove(song)
            } else {
                selectedSongs.add(song)
            }
        }
        songSelectionRv.adapter = adapter

        btnCreatePlaylist.setOnClickListener {
            val playlistName = playlistNameEt.text.toString()
            val playlistDescription = playlistDescriptionEt.text.toString()
            if (playlistName.isNotEmpty() && selectedSongs.isNotEmpty()) {
                val playlist = PlayList(
                    id = System.currentTimeMillis().toString(),
                    name = playlistName,
                    description = playlistDescription,
                    coverImage = 12, // Replace with dynamic value if needed
                    songs = selectedSongs.toMutableList()
                )
                onPlaylistCreated(playlist)
                dismiss()
            }
        }

        return view
    }

    private fun getAllSongs(): ArrayList<Song> {
        return ArrayList(FavoritesRepo.getFavoriteSongs()) // Or your main song list
    }
}
