package com.example.tmezek.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tmezek.fragments.MyArtistFragment
import com.example.tmezek.fragments.MySongsFragment

class FavoritesPagerAdapter(fragment : Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->MySongsFragment()
            1 -> MyArtistFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }

    }
}