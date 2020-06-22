package com.bartoszkrol.mymovies

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var movieImageView: ImageView = itemView.findViewById(R.id.movie_image_view)
    var titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
}
