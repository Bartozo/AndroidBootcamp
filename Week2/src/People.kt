open class People(firstName: String, lastName: String, id: Int, phoneNumber: String, email: String) {
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
}