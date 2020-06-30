package com.bartoszkrol.myanimals.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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
            finish()
        }
    }

    /**
     * check if the given username and password are correct
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
            finish()
        }
    }



}