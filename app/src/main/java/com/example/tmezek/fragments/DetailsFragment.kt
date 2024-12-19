package com.example.tmezek.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.tmezek.R
import com.example.tmezek.adapters.ForYouAdapter
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.Song
import com.example.tmezek.objects.PlaylistRepo
import com.example.tmezek.objects.Songs
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailsFragment : Fragment() {
    lateinit var nomP: String
    lateinit var listt: ArrayList<Song>
    lateinit var adapter: ForYouAdapter
    lateinit var adapter2: SongLIstAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val MesSong: RecyclerView = view.findViewById(R.id.MesSong)
        val buttonSeet: Button = view.findViewById(R.id.addToSheet)
        val imageDetails = view.findViewById<ImageView>(R.id.imageDetails)
        val nomDetails = view.findViewById<TextView>(R.id.titleDetails)
        val descDetails = view.findViewById<TextView>(R.id.descriptionDetails)

        val bundle = arguments
        if (bundle != null) {
            nomP = bundle.getString("title").toString()
            val description = bundle.getString("description")
            val image = bundle.getInt("image")
            nomDetails.text = nomP
            descDetails.text = description
            imageDetails.setImageResource(image)

            MesSong.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            val playlist = PlaylistRepo.findPosition(nomP)
            if (playlist != null) {
                listt = ArrayList(playlist.songs)
                adapter = ForYouAdapter(listt)
                MesSong.adapter = adapter
            }
            parentFragmentManager.setFragmentResultListener("updatePlaylist", this) { _, _ ->
                playlist?.let {
                    listt.clear()
                    listt.addAll(it.songs)
                    adapter.notifyDataSetChanged()
                }
            }
            buttonSeet.setOnClickListener{
                val btnFragment = SheetFragment()
                val bundle2 =Bundle()
                bundle2.putString("title2",nomP)
                btnFragment.arguments=bundle2
                btnFragment.show(parentFragmentManager,btnFragment.tag)
            }
        }
    }
}