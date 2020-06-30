package com.bartoszkrol.myanimals.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bartoszkrol.myanimals.R
import com.bartoszkrol.myanimals.adapter.AnimalAdapter
import com.bartoszkrol.myanimals.model.Animal
import com.bartoszkrol.myanimals.model.AnimalType
import com.bartoszkrol.myanimals.viewmodel.AnimalTypeViewModel
import com.bartoszkrol.myanimals.viewmodel.AnimalsViewModel
import kotlinx.android.synthetic.main.activity_animals.*

class AnimalsActivity : AppCompatActivity() {

    private lateinit var animalsViewModel: AnimalsViewModel
    private lateinit var animalTypeViewModel: AnimalTypeViewModel
    private val animalAdapter = AnimalAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        animalsViewModel = ViewModelProviders.of(this).get(AnimalsViewModel::class.java)
        animalTypeViewModel = ViewModelProviders.of(this).get(AnimalTypeViewModel::class.java)

        animals_recycler_view.layoutManager = LinearLayoutManager(this)
        animals_recycler_view.adapter = animalAdapter

        animalsViewModel.getAnimals().observe(this, Observer<List<Animal>> { animals ->
            animalAdapter.setAnimals(animals ?: emptyList())
        })

        add_animal_fab.setOnClickListener {
            addAnimal()
        }
    }

    private fun addAnimal() {
        animalsViewModel.insert(Animal(name = "test",type = AnimalType.CAT))
    }

    private fun removeAllAnimals() {
        animalsViewModel.removeAnimals()
    }
}