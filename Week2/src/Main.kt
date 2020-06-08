object CafeSystem {
    val shelters = listOf<Shelter>(
        Shelter(1, "Example Street 23", "123456789"),
        Shelter(2, "Boring Street 57", "123456780")
    )
    val cats = listOf<Cat>(
        Cat("Kitty","Bengal", Sex.FEMALE, shelters.random().getId(), 1),
        Cat("Boris","Bengal", Sex.MALE, shelters.random().getId(), 2),
        Cat("Sam","Bengal", Sex.FEMALE, shelters.random().getId(), 3),
        Cat("Sassy","Bengal", Sex.FEMALE, shelters.random().getId(), 4)
    )
    val people = listOf<Person>(
        Employee("Adam","Test",1,"123456234","adam@email.com",
    "12/03/2010",1,1300.0),
        Employee("Jones","Alex",2,"2131245435","jones@email.com",
        "11/08/2011",2,1500.0),
        Employee("Jessica","Cool",3,"5435435645","jessica@email.com",
        "16/05/2012",2,1250.0),
        Patron("Mike","Ray",4,"12354353","mike@email.com"),
        Patron("Donald","Bro",5,"432454353","donald@email.com"),
        Patron("Jacob","Tets",6,"65654353","jacob@email.com")
    )
    val menuItems = listOf(
        Drink("Coca-cola",3.0f,1),
        Drink("Water",1.0f,2),
        Drink("Coffee",2.0f,3),
        Food("cookies",10.0f, 4),
        Food("Chips",5.0f,5),
        Food("Cake",14.0f,6)
    )
    val receipts: MutableList<Receipt> = mutableListOf()

    fun addCatsToShelters() {
        for (shelter in shelters) {
            for (cat in cats) {
                if (shelter.getId() == cat.getShelterid()) {
                    shelter.addCat(cat)
                }
            }
        }
    }

    fun printCatsInTheSystem() {
        println("Cats detected in the system:")
        cats.forEach {
            println("Cat: ${it.getName()}, ${it.getBreed()}, ${it.getSex()}, shelterId: ${it.getShelterid()}, id: ${it.getCatid()}")
        }
    }

    fun printSheltersInTheSystem() {
        println("Shelters detected in the system:")
        CafeSystem.shelters.forEach {
            println("Shelter: ${it.getAddress()}, cats: ${it.getCats().count()}, id: ${it.getId()}")
        }
    }

    fun printPeopleInTheSystem() {
        println("People detected in the system:")
        people.forEach {
            val isEmployee = it is Employee
            println("${it.getFirstName()} ${it.getLastName()}, isEmployee: $isEmployee, id: ${it.getId()}")
        }
    }

    fun printRaport() {
        println("Printing raport...")
        println("total number of transactions: ${receipts.count()}")

        val customers: MutableSet<Person> = mutableSetOf()
        for (receipt in receipts) {
            val customerId = receipt.getCstomerId()
            val customer = people.find { it.getId() == customerId }
            if (customer != null) {
                customers.add(customer)
            }
        }
        println("total number of customers: ${customers.count()}")

        val nonEmployeeNumber = customers.count {
            it is Patron
        }
        println("total number of non-employee: $nonEmployeeNumber")

        println("Adoption per shelters:")
        for (shelter in shelters) {
            println("shelter: ${shelter.getAddress()}")
            println("cats in shelter:")
            for (cat in shelter.getCats()) {
                println("${cat.getName()}, ${cat.getBreed()}, ${cat.getSex()}")
            }
        }

        println("Top selling menu items:")
        val uniqueMenuItem: MutableSet<MenuItem> = mutableSetOf()
        for (receipt in receipts) {
            for (item in receipt.getMenuItems()) {
                uniqueMenuItem.add(item)
            }
        }
        for(item in uniqueMenuItem) {
            println("item: ${item.getName()}")
        }
    }

}

fun main() {

    println("Homework 2: Cat cafe")
    println("Welcome to cat Cafe!")

    println("Loading system data...")
    CafeSystem.addCatsToShelters()
    CafeSystem.printCatsInTheSystem()
    CafeSystem.printSheltersInTheSystem()
    CafeSystem.printPeopleInTheSystem()

    // generate random receipt
    generateRandomReceipt()
    generateRandomReceipt()
    generateRandomReceipt()

    // generate raport
    CafeSystem.printRaport()

}
fun generateRandomReceipt() {
    val customer = CafeSystem.people.random()
    val newReceipt = Receipt(customer.getId())
    newReceipt.addMenuItem(CafeSystem.menuItems.random())
    newReceipt.addMenuItem(CafeSystem.menuItems.random())
    newReceipt.addMenuItem(CafeSystem.menuItems.random())

    CafeSystem.receipts.add(newReceipt)
}