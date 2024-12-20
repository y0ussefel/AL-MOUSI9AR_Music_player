package com.example.tmezek.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.Album

class AlbumSongsAdapter(private val list: ArrayList<Album>) :
    RecyclerView.Adapter<AlbumSongsAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_songs_items, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])


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