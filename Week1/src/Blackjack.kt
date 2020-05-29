class Blackjack {

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

    fun evaluateHand(hand: MutableList<Card>): Int {
        var total = 0
        for (card in hand) {
            val pip = card.pip
            when (pip) {
                "2" -> total += 2
                "3" -> total += 3
                "4" -> total += 4
                "5" -> total += 5
                "6" -> total += 6
                "7" -> total += 7
                "8" -> total += 8
                "9" -> total += 9
                "10" -> total += 10
                "J" -> total += 10
                "Q" -> total += 10
                "K" -> total += 10
                "A" -> total += 11
                else -> {
                    // unknown value
                }
            }
        }

        return total
    }

    fun printResults(hand: MutableList<Card>, total: Int) {
        for ((pip, suit) in hand) {
            println("$pip$suit")
        }

        println("For a total of: $total")
        if (total == 21) {
            println("You Win!")
        } else if (total == 22) {
            println("You Lose!")
        }
    }

}