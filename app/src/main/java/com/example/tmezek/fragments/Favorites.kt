package com.example.tmezek.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.tmezek.R
import com.example.tmezek.adapters.FavoritesPagerAdapter
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.Song
import com.example.tmezek.objects.FavoritesRepo
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class Favorites : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager : ViewPager2
    private lateinit var adapter: FavoritesPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)
        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager =view.findViewById(R.id.viewPagerT)

        adapter = FavoritesPagerAdapter(this)
        viewPager.adapter = adapter

      TabLayoutMediator(tabLayout,viewPager){tab,p ->
            tab.text = when(p){
                0 -> "My Songs"
                1 -> "My Artist"
                else-> null
            }
      }.attach()
        return view
    }




}