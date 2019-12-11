package game;

import org.junit.jupiter.api.Test;
import utils.enums.CardColor;

/**
 * The type Joker card test.
 */
class JokerCardTest {

    /**
     * Gets card color test method.
     */
    @Test
    void getCardColor() {
        JokerCard jokerCard = new JokerCard(CardColor.RED);
        assert jokerCard.getCardColor().equals(CardColor.RED);
    }

    /**
     * Sets card color test method.
     */
    @Test
    void setCardColor() {
        JokerCard jokerCard = new JokerCard(CardColor.RED);
        jokerCard.setCardColor(CardColor.BLACK);
        assert jokerCard.getCardColor().equals(CardColor.BLACK);
    }

    /**
     * Test equals.
     */
    @Test
    void testEquals() {
        JokerCard firstCard = new JokerCard(CardColor.RED);
        JokerCard secondCard = new JokerCard(CardColor.BLACK);
        assert !firstCard.equals(secondCard);
    }

    /**
     * Test hash code.
     */
    @Test
    void testHashCode() {
        JokerCard firstCard = new JokerCard(CardColor.RED);
        JokerCard secondCard = new JokerCard(CardColor.BLACK);
        assert firstCard.hashCode() != secondCard.hashCode();
    }
}