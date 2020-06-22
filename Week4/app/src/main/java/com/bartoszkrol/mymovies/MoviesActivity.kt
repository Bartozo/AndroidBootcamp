package com.bartoszkrol.mymovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movies.*

class MoviesActivity : AppCompatActivity(), MovieListAdapter.MovieClickListener {

    companion object {
        const val MOVIE_TITLE = "MOVIE_TITLE"
        const val MOVIE_DATE = "MOVIE_DATE"
        const val MOVIE_SUMMARY = "MOVIE_SUMMARY"
        const val MOVIE_POSTER = "MOVIE_POSTER"
    }

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
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(MOVIE_TITLE, movie.title)
        intent.putExtra(MOVIE_DATE, movie.date)
        intent.putExtra(MOVIE_SUMMARY, movie.summary)
        intent.putExtra(MOVIE_POSTER, movie.poster)
        startActivity(intent)
    }

}