package com.bartoszkrol.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get data from the intent
        val title = intent.getStringExtra(MoviesActivity.MOVIE_TITLE)
        val date = intent.getStringExtra(MoviesActivity.MOVIE_DATE)
        val summary = intent.getStringExtra(MoviesActivity.MOVIE_SUMMARY)
        val poster = intent.getIntExtra(MoviesActivity.MOVIE_POSTER, -1)

        // Setup UI with data
        title_text_view.text = title
        date_text_view.text = date
        description_text_view.text = summary
        // Check if poster has no defaultValue -1
        if (poster != -1) {
            movie_image_view.setImageResource(poster)
        }

        // Add actionbar title and return button
        val actionbar = supportActionBar
        actionbar?.title =  title
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}