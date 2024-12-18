package com.example.tmezek.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.PlayList
import com.example.tmezek.data.Song
import com.example.tmezek.fragments.DetailsFragment
import com.example.tmezek.fragments.PlayListFragment
import com.example.tmezek.objects.Songs

class PlayListAdapter(
    val list: ArrayList<PlayList>,
    val childFragmentManager: FragmentManager
) : RecyclerView.Adapter<PlayListAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.playlistTitle)
        val description: TextView = itemView.findViewById(R.id.description)
        val image = itemView.findViewById<ImageView>(R.id.playlistCov)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.playlist_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val playlist = list[position]

        holder.title.text = "Title: ${playlist.name}"
        holder.description.text ="Description: ${playlist.description}"
        holder.image.setImageResource(playlist.coverImage)


        holder.itemView.setOnClickListener {
            val fragmentDestination = DetailsFragment()
            val bundle = Bundle()
            bundle.putString("title", playlist.name)
            bundle.putString("description", playlist.description)
            bundle.putInt("image", playlist.coverImage)
            fragmentDestination.arguments = bundle
            childFragmentManager.beginTransaction()
                .replace(R.id.fl, fragmentDestination)
                .addToBackStack(null)
                .commit()
        }
    }
    override fun getItemCount(): Int {
        return list.size
    }

}