class Receipt(customerId: Int) {

    private val menuItems = listOf<MenuItem>()
    private val customerId: Int
    private val receiptTotal: Float
        get() {
            var total = 0f
            menuItems.forEach { total += it.getPrice() }
            return total
        }

    init {
        this.customerId = customerId
    }

}