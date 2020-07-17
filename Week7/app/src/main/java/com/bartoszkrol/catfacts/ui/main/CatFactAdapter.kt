package com.bartoszkrol.catfacts.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bartoszkrol.catfacts.R
import com.bartoszkrol.catfacts.model.CatFact

class CatFactAdapter : RecyclerView.Adapter<CatFactHolder>() {

    private val catFacts = mutableListOf<CatFact>()

    fun setCatFacts(catFacts: List<CatFact>) {
        this.catFacts.clear()
        this.catFacts.addAll(catFacts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatFactHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.catfact_list_item, parent, false)
        return CatFactHolder(view)
    }

    override fun getItemCount(): Int = catFacts.size

    override fun onBindViewHolder(holder: CatFactHolder, position: Int) {
        holder.bindData(catFacts[position])
    }

}