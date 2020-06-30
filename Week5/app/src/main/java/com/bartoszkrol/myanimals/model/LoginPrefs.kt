package com.bartoszkrol.myanimals.model

import android.content.Context
import com.bartoszkrol.myanimals.app.MyAnimalsApplication

object LoginPrefs {

    private const val LOGIN_SHARED_PREFS = "LOGIN_SHARED_PREFS"
    private const val KEY_IS_LOGGED_IN = "KEY_IS_LOGGED_IN"

    private fun sharedPrefs() = MyAnimalsApplication.getAppContext().getSharedPreferences(LOGIN_SHARED_PREFS, Context.MODE_PRIVATE)

    /**
     * set isLoggedIn value
     */
    fun setUserLoggedIn(isLoggedIn: Boolean) = sharedPrefs().edit().putBoolean(KEY_IS_LOGGED_IN, isLoggedIn).apply()

    /**
     * check if user is logged in or no't
     */
    fun isLoggedIn(): Boolean = sharedPrefs().getBoolean(KEY_IS_LOGGED_IN, false)

}