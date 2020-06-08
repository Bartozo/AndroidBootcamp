open class Person(firstName: String, lastName: String, id: Int, phoneNumber: String, email: String) {
    private val firstName: String
    private val lastName: String
    private val id: Int
    private val phoneNumber: String
    private val email: String

    init {
        this.firstName = firstName
        this.lastName = lastName
        this.id = id
        this.phoneNumber = phoneNumber
        this.email = email
    }

    // Getters
    fun getFirstName(): String {
        return this.firstName
    }

    fun getLastName(): String {
        return this.lastName
    }

    fun getId(): Int {
        return this.id
    }

    fun getPhoneNumber(): String {
        return this.phoneNumber
    }

    fun getEmail(): String {
        return this.email
    }
}