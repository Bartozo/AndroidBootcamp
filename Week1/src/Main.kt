fun main() {
    println("Android Bootcamp Challenge one")
    println("Blackjack \n")

    val blackjack = Blackjack()
    val hand = mutableListOf<Card>()

    println("Creating new deck...")
    val deck = blackjack.createDeck().toMutableList()

    println("Drawing 2 cards...")
    hand.addAll(blackjack.dealHand(deck, 2))

    println("Evaluating hand...")
    val total = blackjack.evaluateHand(hand)
    println(total)

    println("Printing the results...")
    blackjack.printResults(hand, total)

}