package game;

import utils.enums.CardColor;
import utils.enums.CardNumber;
import utils.enums.CardSymbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The type Deck.
 */
public class Deck {

    private Queue<Card> cards;

    /**
     * Instantiates a new Deck.
     */
    public Deck() {
        ArrayList<Card> deck = buildDeck();
        shuffle(deck);
        this.cards = new LinkedList<>(deck);
    }

    /**
     * Gets card.
     *
     * @return the card if deck is not empty, null otherwise
     */
    public Card getCard() {
        return this.cards.poll();
    }

    /**
     * Build a deck with 52 cards and 2 Jokers.
     *
     * @return the deck
     */
    private ArrayList<Card> buildDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        CardNumber.stream().forEach(cardNumber -> {
            CardSymbol.stream().forEach(cardSymbol -> {
                deck.add(new StandardCard(cardNumber, cardSymbol));
            });
        });
        CardColor.stream().forEach(cardColor -> deck.add(new JokerCard(cardColor)));
        return deck;
    }

    /**
     * Shuffle the given deck.
     *
     * @param deck the deck
     */
    private void shuffle(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    }
}
