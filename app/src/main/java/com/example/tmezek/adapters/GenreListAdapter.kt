package com.example.tmezek.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tmezek.R
import com.example.tmezek.data.Genre


class GenreListAdapter(private val list: ArrayList<Genre>) :
    RecyclerView.Adapter<GenreListAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_gener_items, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(list[position]){genre ->
            genre.isSelected = !genre.isSelected
            notifyDataSetChanged()
        }


    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return list.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val genreButton: Button = itemView.findViewById(R.id.genreButton)

        fun bindItems(item: Genre, onClick: (Genre) -> Unit) {
            genreButton.text = item.name

            if (item.isSelected) {
                // Set background as a drawable resource for selected state
                genreButton.setBackgroundResource(R.drawable.selected_genre_background)
                genreButton.setTextColor(ContextCompat.getColor(itemView.context, R.color.textColor))
            } else {
                // Set background as a drawable resource for default state
                genreButton.setBackgroundResource(R.drawable.default_genre_background)
                genreButton.setTextColor(ContextCompat.getColor(itemView.context, R.color.primaryColor))
            }

            genreButton.setOnClickListener {
                onClick(item)
            }
        }
    }

}