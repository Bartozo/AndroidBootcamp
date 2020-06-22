package com.bartoszkrol.mymovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter(private val clickListener: MovieClickListener) : RecyclerView.Adapter<MovieListViewHolder>() {

    private val movies = arrayListOf<Movie>()

    interface MovieClickListener {
        fun movieItemClicked(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_view_holder, parent, false)
        return MovieListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.movieImageView.setImageResource(movies[position].poster)
        holder.titleTextView.text = movies[position].title
        holder.itemView.setOnClickListener {
            clickListener.movieItemClicked(movies[position])
        }
    }

}