package com.example.tmezek.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.Artist
import com.example.tmezek.data.Song


class ArtistLIstAdapter(
    private val list: ArrayList<Artist>,
    private val onFavoriteClicked: (Artist) -> Unit
) :
    RecyclerView.Adapter<ArtistLIstAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_artist_itmes, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position],position)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    //the class is hodling the list view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Artist ,position: Int) {
            val title = itemView.findViewById<TextView>(R.id.artistTxt)
            val image = itemView.findViewById<ImageView>(R.id.imageArtistCov)
            val favorite =  itemView.findViewById<ImageView>(R.id.heartArtist)
            title.text = item.name
            image.setImageResource(item.profilePicture)
            favorite.setImageResource(
                if (item.isFavorite) R.drawable.heart_fill else R.drawable.heart
            )

            favorite.setOnClickListener {
                item.isFavorite = !item.isFavorite
                onFavoriteClicked(item)
                notifyItemChanged(position)
            }

        }


    }

}