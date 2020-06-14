package com.bartoszkrol.businesscard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var logoImageView: ImageView
    private lateinit var quoteTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var locationTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var newQuoteButton: Button

    // Object
    companion object {
        private const val QUOTE_KEY = "QUOTE_KEY"
    }

    // Properties

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup views
        logoImageView = findViewById(R.id.logoImageView)
        quoteTextView = findViewById(R.id.quoteTextView)
        nameTextView = findViewById(R.id.nameTextView)
        locationTextView = findViewById(R.id.locationTextView)
        emailTextView = findViewById(R.id.emailTextView)
        newQuoteButton = findViewById(R.id.newQuoteButton)

        newQuoteButton.setOnClickListener { view ->
            newQuote()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionAbout -> showAboutInfo()
            R.id.actionShare -> shareApp()
            R.id.actionVersion -> showVersion()
            else -> {
                // Unknown value
            }
        }
        return true
    }

    private fun showVersion() {
        TODO("Not yet implemented")
    }

    private fun shareApp() {
        TODO("Not yet implemented")
    }

    private fun showAboutInfo() {
        TODO("Not yet implemented")
    }

    private fun newQuote() {
        TODO("Not yet implemented")
    }


}