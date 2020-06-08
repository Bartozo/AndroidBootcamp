
class Employee(firstName: String, lastName: String, id: Int,
               phoneNumber: String, email: String, hireDate: String,
                securityNumber: Int, salary: Double) : People(firstName, lastName, id,
    phoneNumber, email) {

    val hireDate: String
    val securityNumber: Int
    val salary: Double

    init {
        this.hireDate = hireDate
        this.securityNumber = securityNumber
        this.salary = salary
    }

    fun clockIn() {
        println("Time to start the work!")
    }

    fun clockOut() {
        println("It's your free time now.")
    }

}