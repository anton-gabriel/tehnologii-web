package game;

import org.junit.jupiter.api.Test;
import utils.enums.CardNumber;
import utils.enums.CardSymbol;

/**
 * The type Standard card test.
 */
class StandardCardTest {

    /**
     * Gets card number test method.
     */
    @Test
    void getCardNumber() {
        StandardCard standardCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        assert standardCard.getCardNumber() == CardNumber.ACE;
    }

    /**
     * Sets card number test method.
     */
    @Test
    void setCardNumber() {
        StandardCard standardCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        standardCard.setCardNumber(CardNumber.TEN);
        assert standardCard.getCardNumber() == CardNumber.TEN;
    }

    /**
     * Gets card symbol test method.
     */
    @Test
    void getCardSymbol() {
        StandardCard standardCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        standardCard.setCardNumber(CardNumber.TEN);
        assert standardCard.getCardSymbol() == CardSymbol.CLUBS;
    }

    /**
     * Sets card symbol test method.
     */
    @Test
    void setCardSymbol() {
        StandardCard standardCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        standardCard.setCardSymbol(CardSymbol.SPADES);
        assert standardCard.getCardSymbol() == CardSymbol.SPADES;
    }

    /**
     * Test equals test method.
     */
    @Test
    void testEquals() {
        StandardCard firstCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        StandardCard secondCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        assert firstCard.equals(secondCard);
    }

    /**
     * Test hash code test method.
     */
    @Test
    void testHashCode() {
        StandardCard firstCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        StandardCard secondCard = new StandardCard(CardNumber.ACE, CardSymbol.DIAMONDS);
        assert firstCard.hashCode() != secondCard.hashCode();
    }

    /**
     * Test to string test method.
     */
    @Test
    void testToString() {
        StandardCard firstCard = new StandardCard(CardNumber.ACE, CardSymbol.CLUBS);
        StandardCard secondCard = new StandardCard(CardNumber.ACE, CardSymbol.DIAMONDS);
        assert firstCard.toString() != secondCard.toString();
    }
}