package com.example.tmezek.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.Song
import com.example.tmezek.objects.Songs

class SongLIstAdapter(
    private val list: ArrayList<Song>,
    val add:Boolean,
    private val onFavoriteClicked: (Song) -> Unit
) : RecyclerView.Adapter<SongLIstAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_song_itmes, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position], position,holder)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun updateData(newSongs: List<Song>) {
        list.clear()
        list.addAll(newSongs)
        notifyDataSetChanged()
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Song, position: Int,holder: ViewHolder) {
            val title = itemView.findViewById<TextView>(R.id.songTxt)
            val duration = itemView.findViewById<TextView>(R.id.duration)
            val artist = itemView.findViewById<TextView>(R.id.artistTxt)
            val image = itemView.findViewById<ImageView>(R.id.imageCov)
            val favorite = itemView.findViewById<ImageView>(R.id.heartSong)
            val addTo = itemView.findViewById<ImageView>(R.id.addTo)

            title.text = item.title
            duration.text = item.duration.toString()
            artist.text = item.artist.joinToString(", ")
            image.setImageResource(item.coverImage)
            favorite.setImageResource(
                if (item.isFavorite) R.drawable.heart_fill else R.drawable.heart
            )

            favorite.setOnClickListener {
                item.isFavorite = !item.isFavorite
                onFavoriteClicked(item)
                notifyItemChanged(position)
            }

            if (add){
                addTo.visibility = View.VISIBLE
                favorite.visibility = View.GONE
            }else{
                addTo.visibility = View.GONE
                favorite.visibility = View.VISIBLE

            }

            addTo.setOnClickListener{
                onFavoriteClicked(item)
            }
        }
    }
}