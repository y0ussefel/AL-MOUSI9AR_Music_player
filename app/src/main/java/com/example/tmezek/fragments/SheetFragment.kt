package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.ForYouAdapter
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.Song
import com.example.tmezek.objects.PlaylistRepo
import com.example.tmezek.objects.Songs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SheetFragment : BottomSheetDialogFragment() {
    lateinit var adapter2: SongLIstAdapter
    lateinit var nomP: String
    lateinit var listt: ArrayList<Song>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val LesSong = view.findViewById<RecyclerView>(R.id.sheetSong)
        val bundle = arguments
        if (bundle != null) {
            nomP = bundle.getString("title2").toString()
            val playlist = PlaylistRepo.findPosition(nomP)
            if (playlist != null) {
                listt = ArrayList(playlist.songs)
            }
            LesSong.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            val availableSongs = Songs.getSongs()

            adapter2 = SongLIstAdapter(
                ArrayList(availableSongs)
                , true) { song ->
                playlist?.let {
                    if (!it.songs.contains(song)) {
                        PlaylistRepo.update(it, song)
                        listt.clear()
                        listt.addAll(it.songs)

                        val updatedSongs = Songs.getSongs().filter { s -> !it.songs.contains(s) }
                        adapter2.updateData(updatedSongs)

                        parentFragmentManager.setFragmentResult("updatePlaylist", Bundle())
                        Toast.makeText(requireContext(), "Chanson ajoutée à la playlist", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(), "La chanson est déjà dans la playlist", Toast.LENGTH_SHORT).show()
                    }
                }
            }


            LesSong.adapter = adapter2
        }
    }
}