class Shelter(id: Int, address: String, phoneNumber: String) {
    private val id: Int
    private val address: String
    private val phoneNumber: String
    private val cats: MutableList<Cat> = mutableListOf()

    init {
        this.id = id
        this.address = address
        this.phoneNumber = phoneNumber
    }

    // Getters
    fun getId(): Int {
        return this.id
    }

    fun getAddress(): String {
        return this.address
    }

    fun getPhoneNumber(): String {
        return this.phoneNumber
    }

    fun getCats(): List<Cat> {
        return this.cats
    }

    fun getCat(catId: Int): Cat? {
        for (cat in cats) {
            if (cat.getCatid() == catId) {
                return cat
            }
        }
        return null
    }

    // Other
    fun addCat(cat: Cat) {
        cats.add(cat)
    }

    fun removeCat(cat: Cat) {
        cats.remove(cat)
    }
}