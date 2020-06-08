open class MenuItem(name: String, price: Float, id: Int) {
    private val name: String
    private val price: Float
    private val id: Int

    init {
        this.name = name
        this.price = price
        this.id = id
    }


    // Getters
    fun getName(): String {
        return this.name
    }

    fun getPrice(): Float {
        return this.price
    }

    fun getId(): Int {
        return this.id
    }

}