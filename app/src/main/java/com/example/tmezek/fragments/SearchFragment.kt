package com.example.tmezek.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.adapters.SearchAdapter
import com.example.tmezek.adapters.SongLIstAdapter
import com.example.tmezek.data.Song
import com.example.tmezek.objects.Songs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : SongLIstAdapter
    private lateinit var list : ArrayList<Song>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.searchRc)
        val serch = view.findViewById<EditText>(R.id.searchForMusic)

         list = ArrayList (Songs.getSongs())

        adapter = SongLIstAdapter(list,true){}
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter  = adapter

        serch.doAfterTextChanged {
            var search=  serch.text.toString().toLowerCase()
            val listFilter = if(search.isEmpty()){
                ArrayList (Songs.getSongs())
            }else{
                list.filter { it.title.toLowerCase().startsWith(search) }
            }
            list.clear()
            list.addAll(listFilter)
            adapter.notifyDataSetChanged()
        }

    }
}