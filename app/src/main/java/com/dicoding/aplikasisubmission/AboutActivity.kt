package com.dicoding.aplikasisubmission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Reference your views
        val imageView = findViewById<ImageView>(R.id.img_about)
        val nameTextView = findViewById<TextView>(R.id.tv_name)
        val emailTextView = findViewById<TextView>(R.id.tv_email)

        // Set the data
        imageView.setImageResource(R.drawable.putra)
        nameTextView.text = "Putra Rangga"
        emailTextView.text = "BangkitPutra@gmail.com"

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}