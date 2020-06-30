package com.bartoszkrol.myanimals.ui

import android.os.Bundle
import android.widget.EditText
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
        val singleItems = arrayOf(AnimalType.DOG, AnimalType.CAT, AnimalType.BIRD, AnimalType.Other)
        val checkedItem = 0
        var selectedType = AnimalType.DOG

        val editText = EditText(this)
        editText.maxLines = 1 // more lines = buttons will be under the screen

        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.animal_dialog_title))
            .setView(editText)
            .setNeutralButton(resources.getString(R.string.dialog_button_neutral_text)) { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton(resources.getString(R.string.dialog_button_positive_text)) { dialog, _ ->
                animalsViewModel.insert(Animal(name = editText.text.toString(),type = selectedType))
                dialog.dismiss()
            }
            .setSingleChoiceItems(singleItems, checkedItem) { _, which ->
                selectedType = singleItems[which]
            }
            .show()
    }

    private fun removeAllAnimals() {
        animalsViewModel.removeAnimals()
    }
}