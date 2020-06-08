class Cat(name: String, breed: String, sex: Sex, shelterId: Int, catId: Int) {
    private val name: String
    private val breed: String
    private val sex: Sex
    private val shelterId: Int
    private val catId: Int
    private val sponsorships = listOf<Sponsorship>()

    init {
        this.name = name
        this.breed = breed
        this.sex = sex
        this.shelterId = shelterId
        this.catId = catId
    }


    // Getters
    fun getName(): String {
        return this.name
    }

    fun getBreed(): String {
        return this.breed
    }

    fun getSex(): Sex {
        return this.sex
    }

    fun getShelterid(): Int {
        return this.shelterId
    }

    fun getCatid(): Int {
        return this.catId
    }


    // Other
    fun adoptCat(customerId: Int) {
        println("Cat has been adopted by customer with id $customerId")
    }

    fun sponsorCat(customerId: Int) {
        println("Cat has been sponsored by customer with id $customerId")
    }

}