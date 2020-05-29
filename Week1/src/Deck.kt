class Deck {

    val cards = mutableSetOf<Card>()

    fun createDeck(): MutableSet<Card> {
        // unicode characters for the suit
        // /u2663 - club, /u2660 - spade
        // /u2666 - diamond, /u2665 - heart
        val suits = arrayOf('\u2663', '\u2660', '\u2666', '\u2665')
        val pips = arrayOf("2","3","4","5","6","7","8","9","10","J","Q","K","A")
        val cards = mutableSetOf<Card>()

        for (pip in pips) {
            for (suit in suits) {
                val card = Card(pip = pip, suit = suit)
                cards.add(card)
            }
        }

        return cards
    }

    fun dealHand(deck: MutableList<Card>, numberOfCards: Int = 2): MutableList<Card> {
        val cardsToBeDealt = mutableListOf<Card>()

        // if number of cards = 0, then this function will return empty mutable list
        var i = numberOfCards
        while (i > 0) {
            val card = deck.random()
            cardsToBeDealt.add(card)
            deck.remove(card)

            i -= 1
        }

        return cardsToBeDealt
    }

}