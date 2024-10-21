package com.dicoding.aplikasisubmission

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListsongsAdapter(
    private val listSongs: ArrayList<Songs>,
    private val context: Context // Add context parameter
) : RecyclerView.Adapter<ListsongsAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_songs, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val song = listSongs[position]
        holder.imgPhoto.setImageResource(song.photo)
        holder.tvName.text = song.name
        holder.tvDescription.text = song.description

        // Set click listener on the item view
        holder.itemView.setOnClickListener {
            // Create an Intent to start DetailActivity
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_SONG_NAME, song.name)
                putExtra(DetailActivity.EXTRA_SONG_DESCRIPTION, song.description)
                putExtra(DetailActivity.EXTRA_SONG_IMAGE, song.photo)
                putExtra(DetailActivity.EXTRA_SONG_ARTIST, song.Artist)
                putExtra(DetailActivity.EXTRA_SONG_PRODUCER, song.Producer)
            }
            context.startActivity(intent) // Start the DetailActivity
        }
    }

    override fun getItemCount(): Int = listSongs.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
}


