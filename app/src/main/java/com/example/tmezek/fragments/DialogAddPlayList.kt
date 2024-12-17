package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.PlayList
import com.example.tmezek.objects.PlaylistRepo
import com.example.tmezek.objects.Songs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogAddPlayList.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogAddPlayList : Fragment() {
    private lateinit var title: EditText
    private lateinit var descriptoin: EditText



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_add_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        title = view.findViewById(R.id.titlePlayList)
        descriptoin = view.findViewById(R.id.playlistDescription)
        val btnAdd = view.findViewById<Button>(R.id.addPlayListTo)


        btnAdd.setOnClickListener{
            PlaylistRepo.addPlaylist(PlayList("1",title.text.toString(),descriptoin.text.toString()
                ,null,Songs.getSongsList().toMutableList()))
        }

    }


}