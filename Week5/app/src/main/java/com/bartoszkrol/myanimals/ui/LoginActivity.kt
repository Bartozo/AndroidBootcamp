package com.bartoszkrol.myanimals.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bartoszkrol.myanimals.R
import com.bartoszkrol.myanimals.model.LoginPrefs
import com.bartoszkrol.myanimals.model.User
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val user = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        isLoggedIn()

        loginButton.setOnClickListener {
            checkUsernameAndPassword()
        }
    }

    /**
     * Check if user was logged in
     */
    private fun isLoggedIn() {
        if (LoginPrefs.isLoggedIn()) {
            val intent = Intent(this, AnimalsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    /**
     * check if the given username and password are correct
     * if password and username are correct then start new activity
     */
    private fun checkUsernameAndPassword() {
        val username = usernameInputEditText.text.toString()
        val password = passwordInputEditText.text.toString()

        user.setUsernameAndPassword(username, password)

        if (!user.isUsernameValid()) {
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.warning))
                .setMessage(getString(R.string.invalid_username))
                .setPositiveButton(R.string.dialog_button_positive_text) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        } else if (!user.isPasswordValid()) {
            MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.warning))
                .setMessage(getString(R.string.invalid_password))
                .setPositiveButton(R.string.dialog_button_positive_text) { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        } else {
            LoginPrefs.setUserLoggedIn(true)
            val intent = Intent(this, AnimalsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }



}