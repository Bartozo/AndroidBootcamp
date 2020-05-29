fun main() {
    println("Android Bootcamp Challenge one")
    println("Blackjack \n")

    val dealer = Deck()
    val hand = mutableListOf<Card>()

    println("Creating new deck...")
    val deck = dealer.createDeck()

    println("Drawing 2 cards...")
    hand.addAll(dealer.dealHand(deck.toMutableList(), 2))

    println("Evaluating hand...")
    val total = dealer.evaluateHand(hand)
    println(total)

    println("Printing the results...")
    dealer.printResults(hand, total)

}