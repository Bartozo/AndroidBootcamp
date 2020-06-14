package com.bartoszkrol.businesscard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

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

    /**
     * Show the dialog for the app version
     */
    private fun showVersion() {
        val appName = getString(R.string.app_name)
        val versionName = BuildConfig.VERSION_NAME

        showDialog(appName, versionName)
    }

    /**
     * Show the dialog about sharing the app
     */
    private fun shareApp() {
        val title = getString(R.string.shareTitle)
        val message = getString(R.string.shareMessage)

        showDialog(title, message)
    }

    /**
     * Show the dialog with basic information's
     * about the app
     */
    private fun showAboutInfo() {
        val title = getString(R.string.aboutTitle)
        val message = getString(R.string.aboutMessage)

        showDialog(title, message)
    }

    private fun newQuote() {
        TODO("Not yet implemented")
    }

    /**
     * Create and show dialog
     *
     * @param title title of the dialog
     * @param message message of the dialog
     */
    private fun showDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.create().show()
    }


}