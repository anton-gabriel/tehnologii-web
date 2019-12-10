package game;

import org.junit.jupiter.api.Test;

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
}