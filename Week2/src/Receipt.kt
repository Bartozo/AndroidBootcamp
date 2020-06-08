import java.awt.Menu

class Receipt(customerId: Int) {

    private val menuItems: MutableList<MenuItem> = mutableListOf()
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

    // Getters
    fun getMenuItems(): List<MenuItem> {
        return this.menuItems
    }

    fun getCstomerId(): Int {
        return this.customerId
    }

    fun getTotal(): Float {
        return  this.receiptTotal
    }

    // Other
    fun addMenuItem(menuItem: MenuItem) {
        this.menuItems.add(menuItem)
    }

}