package com.example.tmezek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.PlayListAdapter
import com.example.tmezek.data.PlayList
import com.example.tmezek.objects.PlaylistRepo

class PlayListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PlayListAdapter
    lateinit var list:ArrayList<PlayList>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.playlist_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.listOfPlayList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        list = ArrayList(PlaylistRepo.getPlaylists())
        adapter = PlayListAdapter(list,parentFragmentManager)
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()

        val addPlayList = view.findViewById<ImageView>(R.id.addPlayList)

        addPlayList.setOnClickListener {
            val dialogView = layoutInflater.inflate(R.layout.dialog_add_playlist, null)
            val editTextFirst = dialogView.findViewById<EditText>(R.id.titlePlayList)
            val editTextSecond = dialogView.findViewById<EditText>(R.id.playlistDescription)

            val alertDialog = AlertDialog.Builder(requireContext())
                .setTitle("Ajouter une nouvelle playlist")
                .setView(dialogView)
                .setPositiveButton("OK") { dialog, _ ->
                    val title = editTextFirst.text.toString().trim()
                    val description = editTextSecond.text.toString().trim()

                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        val newPlaylist = PlayList("1", title, description)
                        PlaylistRepo.addPlaylist(newPlaylist)
                        list.clear()
                        list.addAll(PlaylistRepo.getPlaylists())
                        adapter.notifyDataSetChanged()
                        adapter.notifyItemInserted(list.size - 1)

                    } else {
                        Toast.makeText(requireContext(), "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Annuler") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()

            alertDialog.show()
        }

    }
}