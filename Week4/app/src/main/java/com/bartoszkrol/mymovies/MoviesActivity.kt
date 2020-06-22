package com.bartoszkrol.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : AppCompatActivity(), MovieListAdapter.MovieClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        movies_recycler_view.layoutManager = LinearLayoutManager(this)
        movies_recycler_view.adapter = MovieListAdapter(this)
    }

    /**
     * starts a new activity to show more details about the selected movie
     */
    override fun movieItemClicked(movie: Movie) {

    }

}