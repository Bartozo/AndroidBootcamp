package com.bartoszkrol.myanimals.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bartoszkrol.myanimals.R
import com.bartoszkrol.myanimals.model.Animal
import com.bartoszkrol.myanimals.model.AnimalType
import com.bartoszkrol.myanimals.viewmodel.AnimalsViewModel
import kotlinx.android.synthetic.main.fragment_animaldetails.*


class AnimalDetailsFragment : DialogFragment(), Toolbar.OnMenuItemClickListener {

    private lateinit var animalViewModel: AnimalsViewModel
    private lateinit var animal: Animal

    companion object {
        const val ANIMAL_KEY = "ANIMAL_KEY"
        const val ANIMAL_DETAILS_FRAGMENT_TAG = "ANIMAL_DETAILS_FRAGMENT_TAG"

        fun newInstance(animal: Animal): AnimalDetailsFragment {
            val fragment = AnimalDetailsFragment()
            val args = Bundle().apply {
                putParcelable(ANIMAL_KEY, animal)
            }
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // this code set fragment style (to be like appTheme, without it fragment dialog is small)
        setStyle(STYLE_NORMAL, R.style.AppTheme_Fragment)
        animalViewModel = ViewModelProvider(this).get(AnimalsViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // add animations
        dialog!!.window?.attributes?.windowAnimations = R.style.AppTheme_Fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_animaldetails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set listener for toolbar
        detailsToolbar.setNavigationOnClickListener {
            dismiss()
        }

        // inflate menu
        detailsToolbar.inflateMenu(R.menu.animaldetails_menu)
        detailsToolbar.setOnMenuItemClickListener(this)
        // get favorite button and cast it as a checkbox
        val starMenuItem = detailsToolbar.menu.findItem(R.id.action_favorite)
        val checkBox = starMenuItem.actionView as CheckBox

        arguments?.getParcelable<Animal>(ANIMAL_KEY)?.let { animal = it  }

        animalViewModel.getAnimal(animal.id).observe(viewLifecycleOwner, Observer {
            this.animal = it
            setupFavorite(checkBox, it)
            setupAnimal(it)
        })

    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_delete -> {
                deleteAnimal()
                true
            }
            else -> false
        }
    }

    /**
     * updates the layout with animal
     */
    private fun setupAnimal(animal: Animal) {
        animalNameTextView.text = animal.name
        animalDescriptionTextView.text = animal.description
        when (animal.type) {
            AnimalType.DOG -> animalImageView.setImageResource(R.drawable.dog)
            AnimalType.CAT -> animalImageView.setImageResource(R.drawable.cat)
            AnimalType.BIRD -> animalImageView.setImageResource(R.drawable.bird)
            AnimalType.Other -> animalImageView.setImageResource(R.drawable.other)
        }
    }

    /**
     * set animal as a favorite
     */
    private fun setupFavorite(checkBox: CheckBox, animal: Animal) {
        checkBox.setOnCheckedChangeListener { _ , checked ->
            animal.favorite = checked
            animalViewModel.updateAnimal(animal)
        }
        // set checkbox value
        checkBox.isChecked = animal.favorite
    }


    /**
     * remove animal and close the DialogFragment
     */
    private fun deleteAnimal() {
        animalViewModel.removeAnimal(animal)
        dismiss()
    }


}