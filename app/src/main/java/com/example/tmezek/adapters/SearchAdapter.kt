package com.example.tmezek.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.PlayList
import com.example.tmezek.data.Song


class SearchAdapter(
    private val list: ArrayList<Song>
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    // This method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_search_items, parent, false)
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

        fun bindItems(item: Song) {
            val title = itemView.findViewById<TextView>(R.id.titleSearch)
            val artistName = itemView.findViewById<TextView>(R.id.artistNameSearch)
            val coverSong = itemView.findViewById<ImageView>(R.id.coverSearch)

            title.text = item.title
            artistName.text = item.artist.joinToString(",")
            coverSong.setImageResource(item.coverImage)



        }
    }
}