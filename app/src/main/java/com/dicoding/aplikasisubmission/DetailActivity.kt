package com.dicoding.aplikasisubmission

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SONG_NAME = "EXTRA_SONG_NAME"
        const val EXTRA_SONG_DESCRIPTION = "EXTRA_SONG_DESCRIPTION"
        const val EXTRA_SONG_IMAGE = "EXTRA_SONG_IMAGE"
        const val EXTRA_SONG_ARTIST = "EXTRA_SONG_ARTIST"
        const val EXTRA_SONG_PRODUCER = "EXTRA_SONG_PRODUCER"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Retrieve the data from the intent
        val songName = intent.getStringExtra(EXTRA_SONG_NAME)
        val songDescription = intent.getStringExtra(EXTRA_SONG_DESCRIPTION)
        val songImage = intent.getIntExtra(EXTRA_SONG_IMAGE, -1)
        val songArtist = intent.getStringExtra(EXTRA_SONG_ARTIST)
        val songProducer = intent.getStringExtra(EXTRA_SONG_PRODUCER)

        // Initialize your views
        val photo: ImageView = findViewById(R.id.img_detail)
        val name: TextView = findViewById(R.id.tv_detail_title)
        val description: TextView = findViewById(R.id.tv_detail_description)
        val artist: TextView = findViewById(R.id.tv_artist)
        val producer: TextView = findViewById(R.id.tv_producer)

        // Set the data to the views
        photo.setImageResource(songImage)
        name.text = songName
        description.text = songDescription
        artist.text = "Singer: $songArtist"
        producer.text = "Producer: $songProducer"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Menangani klik tombol kembali
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
