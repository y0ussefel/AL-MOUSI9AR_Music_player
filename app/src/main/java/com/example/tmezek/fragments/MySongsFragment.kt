package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.Song
import com.example.tmezek.objects.FavoritesRepo

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MySongsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MySongsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SongLIstAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v=  inflater.inflate(R.layout.fragment_my_songs, container, false)
        recyclerView= v.findViewById(R.id.mySongsRv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = SongLIstAdapter(FavoritesRepo.getFavoriteSongs() as ArrayList){ song ->
            FavoritesRepo.removeFavoriteSong(song)
            adapter.notifyDataSetChanged()
        }

        recyclerView.adapter = adapter

        return v
    }



}