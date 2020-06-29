package com.bartoszkrol.mymovies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieListAdapter(private val clickListener: MovieClickListener) : RecyclerView.Adapter<MovieListViewHolder>() {

    private val movies = arrayListOf(
        Movie(
            1,
            "23/04/2018",
            "Avengers: Infinity War",
            "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, " +
                    "produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. " +
                    "It is the sequel to The Avengers (2012) and Avengers: Age of Ultron (2015), and the 19th film in the Marvel Cinematic Universe (MCU).",
            R.drawable.infinity_war
        ),
        Movie(
            2,
            "30/03/2013",
            "Dragon Ball Z: Battle of Gods",
            "Battle of Gods was the first film considered an official part of the Dragon Ball storyline, " +
                    "being set during the time skip in chapter 517 of the original manga, with original creator Akira Toriyama deeply involved." +
                    " The plot involves Beerus, the God of Destruction, learning of the defeat of the galactic overlord Frieza at the hands of Goku. " +
                    "Seeking an opponent worthy of his power, Beerus, along with his companion Whis, travels to the North Galaxy to challenge Goku to a battle.",
            R.drawable.dragon_ball
        ),
        Movie(
            3,
            "10/06/2016",
            "Warcraft",
            "Warcraft (alternatively known as Warcraft: The Beginning) is a 2016 American action fantasy film directed by Duncan Jones and written by Charles Leavitt and Jones." +
                    " Based on the video game series of the same name, the film stars Travis Fimmel, Paula Patton, Ben Foster, Dominic Cooper, Toby Kebbell, Ben Schnetzer, Robert Kazinsky, " +
                    "Clancy Brown, and Daniel Wu. The film portrays the initial encounters between the humans and the orcs and takes place in a variety of locations established in the video game series.",
            R.drawable.warcraft
        )
    )

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