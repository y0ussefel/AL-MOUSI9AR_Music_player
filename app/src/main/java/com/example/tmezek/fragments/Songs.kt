package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.tmezek.R
import com.example.tmezek.adapters.SongsFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Songs : Fragment() {

    private lateinit var pager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private  lateinit var fragmentAdapter: SongsFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_songs, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pager = view.findViewById(R.id.viewPager2)
        tabLayout = view.findViewById(R.id.tab2)

        fragmentAdapter = SongsFragmentAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        pager.adapter = fragmentAdapter

//        tabLayout.addTab(tabLayout.newTab().setText("Songs"))
//        tabLayout.addTab(tabLayout.newTab().setText("Artist"))
//        tabLayout.addTab(tabLayout.newTab().setText("Album"))
//        tabLayout.addTab(tabLayout.newTab().setText("Genre"))

        TabLayoutMediator(tabLayout,pager){tab,po ->
            tab.text =when(po){
                0-> "songs"
                1-> "artsit"
                2-> "sss"
                3-> "sos"
                else -> null
            }

        }.attach()



//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                if (tab != null) {
//                    pager.currentItem = tab.position
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                Toast.makeText(requireContext(),"Unselected tab",Toast.LENGTH_SHORT).show()
//            }
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Toast.makeText(requireContext(),"reselected tab",Toast.LENGTH_SHORT).show()
//            }
//        })
//
//        pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                tabLayout.selectTab(tabLayout.getTabAt(position))
//            }
//        }
//        pager.registerOnPageChangeCallback(pageChangeCallback)
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        pager.unregisterOnPageChangeCallback(pageChangeCallback)
//    }
}

class ViewPagerRacingAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> ListSongsFragment()
        1 -> ListArtistFragment()
        2 -> ListAlbumFragment()
        3 -> ListGenerFragment()
        else -> throw IllegalArgumentException("Invalid position")
    }
}


