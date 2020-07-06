package com.bartoszkrol.myanimals.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bartoszkrol.myanimals.R
import com.bartoszkrol.myanimals.adapter.AnimalAdapter
import com.bartoszkrol.myanimals.model.Animal
import com.bartoszkrol.myanimals.model.AnimalType
import com.bartoszkrol.myanimals.model.LoginPrefs
import com.bartoszkrol.myanimals.ui.details.AnimalDetailsFragment
import com.bartoszkrol.myanimals.ui.login.LoginActivity
import com.bartoszkrol.myanimals.viewmodel.AnimalTypeViewModel
import com.bartoszkrol.myanimals.viewmodel.AnimalsViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_animals.*


class AnimalsActivity : AppCompatActivity(), AnimalAdapter.AnimalClickListener {

    private lateinit var animalsViewModel: AnimalsViewModel
    private lateinit var animalTypeViewModel: AnimalTypeViewModel
    private val animalAdapter = AnimalAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        animalsViewModel = ViewModelProvider(this).get(AnimalsViewModel::class.java)
        animalTypeViewModel = ViewModelProvider(this).get(AnimalTypeViewModel::class.java)

        animals_recycler_view.layoutManager = LinearLayoutManager(this)
        animals_recycler_view.adapter = animalAdapter

        animalsViewModel.getAnimals().observe(this, Observer<List<Animal>> { animals ->
            animalAdapter.setAnimals(animals ?: emptyList())
        })

        add_animal_fab.setOnClickListener {
            addAnimal()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.animal_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> logout()
            R.id.action_remove_all -> removeAllAnimals()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * logout the user from the app and set isLoggedIn to false
     */
    private fun logout() {
        LoginPrefs.setUserLoggedIn(false)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    /**
     * add an animal to the database
     */
    private fun addAnimal() {
        val singleItems = arrayOf(AnimalType.DOG, AnimalType.CAT, AnimalType.BIRD, AnimalType.Other)
        val checkedItem = 0
        var selectedType = AnimalType.DOG

        // Create layout for dialog
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val nameEditText = EditText(this)
        nameEditText.hint = "Animal name..."
        nameEditText.maxLines = 1
        layout.addView(nameEditText)

        val descriptionEditText = EditText(this)
        descriptionEditText.hint = "description..."
        descriptionEditText.maxLines = 1
        layout.addView(descriptionEditText)

        // Build and show dialog
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.animal_dialog_title))
            .setView(layout)
            .setNeutralButton(resources.getString(R.string.dialog_button_neutral_text)) { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton(resources.getString(R.string.dialog_button_positive_text)) { dialog, _ ->
                animalsViewModel.insert(Animal(name = nameEditText.text.toString(),
                    type = selectedType, description = descriptionEditText.text.toString()))
                dialog.dismiss()
            }
            .setSingleChoiceItems(singleItems, checkedItem) { _, which ->
                selectedType = singleItems[which]
            }
            .show()
    }

    /**
     * remove all animals from the database
     */
    private fun removeAllAnimals() {
        animalsViewModel.removeAnimals()
    }

    /**
     * start new screen with selected animal
     */
    override fun animalItemClicked(animal: Animal) {
        val fragment = AnimalDetailsFragment.newInstance(animal)
        fragment.show(supportFragmentManager, AnimalDetailsFragment.ANIMAL_DETAILS_FRAGMENT_TAG)
    }
}