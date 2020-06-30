package com.bartoszkrol.myanimals.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bartoszkrol.myanimals.R
import com.bartoszkrol.myanimals.model.Animal
import com.bartoszkrol.myanimals.model.AnimalType

class AnimalAdapter() : RecyclerView.Adapter<AnimalViewHolder>() {

    private val animals = mutableListOf<Animal>()

    fun setAnimals(animals: List<Animal>) {
        this.animals.clear()
        this.animals.addAll(animals)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animal_list_item, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.name.text = animals[position].name
        val type = animals[position].type
        when (type) {
            AnimalType.DOG -> println()
            AnimalType.CAT -> println()
            AnimalType.BIRD -> println()
            AnimalType.Other -> println()
        }
    }


}