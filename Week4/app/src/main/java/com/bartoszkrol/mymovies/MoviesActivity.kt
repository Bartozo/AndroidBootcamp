package com.bartoszkrol.mymovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_movies.*
import java.lang.Exception

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionAbout ->  {
                val title = getString(R.string.actionAbout)
                val message = getString(R.string.aboutDialogMessage)
                showDialog(title, message)
            }
            R.id.actionVersion -> {
                val title = getString(R.string.actionVersion)
                val versionName = BuildConfig.VERSION_NAME
                showDialog(title, versionName)
            }
            else -> {
                // Unknown value
            }
        }
        return true
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

    /**
     * Create and show dialog
     *
     * @param title - title of the dialog
     * @param message - message of the dialog
     */
    private fun showDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.positive_button_ok) { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}