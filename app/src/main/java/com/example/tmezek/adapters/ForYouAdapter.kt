package com.example.tmezek.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.Song


class ForYouAdapter(private val list: ArrayList<Song>, val onSongClicked:(Song) -> Unit) :
    RecyclerView.Adapter<ForYouAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.for_you_item, parent, false)
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
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Song) {
            val title = itemView.findViewById<TextView>(R.id.songName3)
            val artist = itemView.findViewById<TextView>(R.id.artist3)
            val image = itemView.findViewById<ImageView>(R.id.image3)


            title.text = item.title
            artist.text = item.artist.joinToString(",")
            image.setImageResource(item.coverImage)

            itemView.setOnClickListener{
                onSongClicked(item)
            }

        }
    }

}