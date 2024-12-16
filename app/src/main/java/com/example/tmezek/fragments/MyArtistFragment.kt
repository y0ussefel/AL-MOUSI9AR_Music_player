package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.ArtistLIstAdapter
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.objects.FavoritesRepo


class MyArtistFragment : Fragment() {

private lateinit var recyclerView: RecyclerView
private lateinit var adapter: ArtistLIstAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_my_artist, container, false)
        recyclerView = v.findViewById(R.id.myArtistRv)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = ArtistLIstAdapter(FavoritesRepo.getFavoriteArtists() as  ArrayList){artist ->
            FavoritesRepo.removeFavoriteArtist(artist)

            adapter.notifyDataSetChanged()
        }

        recyclerView.adapter = adapter


        return v
    }


}