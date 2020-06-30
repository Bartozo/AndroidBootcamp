package com.bartoszkrol.myanimals.model

class User {

    private lateinit var username: String
    private lateinit var password: String

    fun setUsernameAndPassword(username: String, password: String) {
        this.username = username
        this.password = password
    }

    /**
     * Check if username is valid
     *
     * no whitespace allowed (?=\\S+$)
     * username can be 1 to 10 characters long {1,10}
     * @return - returns true or false
     */
    fun isUsernameValid(): Boolean {
        val usernamePattern = "(?=\\S+$).{1,10}"
        val matcher = Regex(usernamePattern)

        return matcher.find(username) != null
    }

    /**
     * Check if password is valid
     *
     * at least one digit (?=.*[0-9])
     * at least one lower case letter (?=.*[a-z])
     * at least one upper case letter (?=.*[A-Z])
     * password can be 4 to 10 characters long {4,10}$
     * @return - returns true or false
     */
    fun isPasswordValid(): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[0-9])(?=.*[A-Z]).{4,10}"
        val matcher = Regex(passwordPattern)

        return matcher.find(password) != null
    }

}