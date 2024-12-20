package com.example.tmezek.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.Album
import com.example.tmezek.fragments.AlbumSongs


class AlbumListAdaper(private val list: ArrayList<Album>,var parentFragment : FragmentManager) :
    RecyclerView.Adapter<AlbumListAdaper.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_album_items, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
        val item = list[position]
        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("titleAlbum",item.title)
            bundle.putInt("coverAlbum",item.coverImage)
            AlbumSongs().arguments = bundle
            parentFragment.beginTransaction()
                .replace(R.id.fl,AlbumSongs())

        }

    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Album) {
            val titleAlbum = itemView.findViewById<TextView>(R.id.alumTitle)
            val artistAlbum = itemView.findViewById<TextView>(R.id.artistAlbm)
            val cover = itemView.findViewById<ImageView>(R.id.imageAlbm)
            val playImag = itemView.findViewById<ImageView>(R.id.playImg)

            titleAlbum.text = item.title
            artistAlbum.text = item.artist
            cover.setImageResource(item.coverImage)



        }
    }

}