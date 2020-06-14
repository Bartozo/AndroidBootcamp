package com.bartoszkrol.businesscard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    private fun newQuote() {
        TODO("Not yet implemented")
    }


}