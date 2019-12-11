package game;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * The type Deck test.
 */
class DeckTest {

    /**
     * Gets card test method.
     */
    @Test
    void getCard() {
        Deck deck = new Deck();
        assert deck.getCard() != null;
    }

    /**
     * Gets cards test method.
     */
    @Test
    void getCards() {
        Deck deck = new Deck();
        assert deck.getCards() != null;
    }

    /**
     * Sets cards test method.
     */
    @Test
    void setCards() {
        Deck deck = new Deck();
        deck.setCards(new LinkedList<>());
        assert deck.getCards() != null;
    }
}