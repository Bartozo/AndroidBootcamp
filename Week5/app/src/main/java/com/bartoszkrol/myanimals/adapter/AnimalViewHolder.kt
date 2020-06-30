package com.bartoszkrol.myanimals.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bartoszkrol.myanimals.R
import com.bartoszkrol.myanimals.model.Animal
import kotlinx.android.synthetic.main.animal_list_item.*
import kotlinx.android.synthetic.main.animal_list_item.view.*

class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var photo: ImageView = itemView.animalImageView
    var name: TextView = itemView.animalTextView
}