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
import com.example.tmezek.data.PlayList
import com.example.tmezek.data.Song
import com.example.tmezek.objects.Songs

class PlayListAdapter(
    private val list: ArrayList<PlayList>,
) : RecyclerView.Adapter<PlayListAdapter.ViewHolder>() {

    // This method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.playlist_item, parent, false)
        return ViewHolder(v)
    }

    // This method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position])
    }

    // This method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    // The class is holding the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: PlayList) {
            val title = itemView.findViewById<TextView>(R.id.playlistTitle)

            title.text = item.name



        }
    }
}