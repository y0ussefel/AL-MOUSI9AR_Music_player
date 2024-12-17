package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R


class PlayListFragment : Fragment() {
private lateinit var recyclerView: RecyclerView
private lateinit var adapter: PlayListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.playlist_fragment, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.listOfPlayList)
        val addPlayList = view.findViewById<ImageView>(R.id.addPlayList)

        addPlayList.setOnClickListener{

        }
    }

    private fun displayDialog(){
        val dialogView = LayoutInflater .from(requireContext()).inflate(R.layout.dialog_add_playlist,null)
        val title = dialogView.findViewById<EditText>(R.id.titlePlayList)
        val desc = dialogView.findViewById<EditText>(R.id.PlaylistDescription)


    }



}