package com.dicoding.aplikasisubmission

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var rvSongs: RecyclerView
    private lateinit var toolbar: Toolbar
    private val list = ArrayList<Songs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvSongs = findViewById(R.id.rv_songs)
        rvSongs.setHasFixedSize(true)

        list.addAll(getListSongs())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_profile, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_profile -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListSongs(): ArrayList<Songs> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSongs = ArrayList<Songs>()
        val dataArtist = resources.getStringArray(R.array.data_artist)
        val dataProducer = resources.getStringArray(R.array.data_producer)

        for (i in dataName.indices) {
            val song = Songs(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                dataArtist[i],
                dataProducer[i]
            )
            listSongs.add(song)
        }
        dataPhoto.recycle()
        return listSongs
    }

    private fun showRecyclerList() {
        rvSongs.layoutManager = LinearLayoutManager(this)
        val listsongsAdapter = ListsongsAdapter(list, this)
        rvSongs.adapter = listsongsAdapter
    }
}
