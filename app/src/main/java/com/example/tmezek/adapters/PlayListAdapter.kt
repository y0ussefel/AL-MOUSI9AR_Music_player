package com.example.tmezek.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.Song
import com.example.tmezek.objects.Songs

class PlayListAdapter(
    private val list: ArrayList<Song>,
) : RecyclerView.Adapter<SongLIstAdapter.ViewHolder>() {

    // This method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.playlist_item, parent, false)
        return ViewHolder(v)
    }

    // This method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position], position)
    }

    // This method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    // The class is holding the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Song, position: Int) {
            val title = itemView.findViewById<TextView>(R.id.playlistTitle)
            val  = itemView.findViewById<TextView>(R.id.playlistTitle)
            val addTo = itemView.findViewById<ImageButton>(R.id.addPlayList)




            }


        }
    }
}