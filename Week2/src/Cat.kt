class Cat(name: String, breed: String, sex: Sex, shelterId: Int, catId: Int) {
    val name: String
    val breed: String
    val sex: Sex
    val shelterId: Int
    val catId: Int
    val sponsorships = listOf<Sponsorship>()

    init {
        this.name = name
        this.breed = breed
        this.sex = sex
        this.shelterId = shelterId
        this.catId = catId
    }

    fun adoptCat(customerId: Int) {
        println("Cat has been adopted by customer with id $customerId")
    }

    fun sponsorCat(customerId: Int) {
        println("Cat has been sponsored by customer with id $customerId")
    }

}