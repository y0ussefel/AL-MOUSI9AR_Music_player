package com.example.tmezek.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.PlayList

class PlaylistAdapter(
    private val playlists: List<PlayList>,
    private val onPlaylistClicked: (PlayList) -> Unit
) : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_playlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val playlist = playlists[position]
        holder.bind(playlist)
    }

    override fun getItemCount(): Int = playlists.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.playlistName)
        private val description = itemView.findViewById<TextView>(R.id.playlistDescription)
        private val cover = itemView.findViewById<ImageView>(R.id.playlistCover)

        fun bind(playlist: PlayList) {
            name.text = playlist.name
            description.text = playlist.description ?: "No description"
            cover.setImageResource(playlist.coverImage ?: R.drawable.cover1)

            itemView.setOnClickListener {
                onPlaylistClicked(playlist)
            }
        }
    }
}
