package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.tmezek.R
import com.example.tmezek.adapters.SongsFragmentAdapter
import com.google.android.material.tabs.TabLayout

class Songs : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tab: TabLayout
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
    private lateinit var pageChangeCallback: ViewPager2.OnPageChangeCallback
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.viewPager2)
        tab = view.findViewById(R.id.tab2)

        fragmentAdapter = SongsFragmentAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)
        viewPager.adapter = fragmentAdapter

        tab.addTab(tab.newTab().setText("Songs"))
        tab.addTab(tab.newTab().setText("Artist"))
        tab.addTab(tab.newTab().setText("Album"))
        tab.addTab(tab.newTab().setText("Genre"))

        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tab.selectTab(tab.getTabAt(position))
            }
        }
        viewPager.registerOnPageChangeCallback(pageChangeCallback)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPager.unregisterOnPageChangeCallback(pageChangeCallback)
    }
}


