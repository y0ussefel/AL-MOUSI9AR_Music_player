package com.example.tmezek.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tmezek.fragments.ListAlbumFragment
import com.example.tmezek.fragments.ListArtistFragment
import com.example.tmezek.fragments.ListGenerFragment
import com.example.tmezek.fragments.ListSongsFragment


class SongsFragmentAdapter(manager: FragmentManager, lifeCycle: Lifecycle)
    : FragmentStateAdapter(manager,lifeCycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position ){
           0-> ListSongsFragment()
           1-> ListArtistFragment()
           2-> ListAlbumFragment()
           3-> ListGenerFragment()
            else -> throw IllegalStateException("Unexpected position $position")

        }
    }

}