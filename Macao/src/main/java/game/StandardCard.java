package game;

import utils.enums.CardNumber;
import utils.enums.CardSymbol;

import java.util.Objects;

/**
 * The type Card.
 */
public class StandardCard implements Card {
    private CardNumber cardNumber;
    private CardSymbol cardSymbol;

    /**
     * Instantiates a new Card.
     *
     * @param cardNumber the card number
     * @param cardSymbol the card symbol
     */
    public StandardCard(CardNumber cardNumber, CardSymbol cardSymbol) {
        this.cardNumber = cardNumber;
        this.cardSymbol = cardSymbol;
    }

    /**
     * Gets card number.
     *
     * @return the card number
     */
    public CardNumber getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets card number.
     *
     * @param cardNumber the card number
     */
    public void setCardNumber(CardNumber cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets card symbol.
     *
     * @return the card symbol
     */
    public CardSymbol getCardSymbol() {
        return cardSymbol;
    }

    /**
     * Sets card symbol.
     *
     * @param cardSymbol the card symbol
     */
    public void setCardSymbol(CardSymbol cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StandardCard that = (StandardCard) o;
        return cardNumber == that.cardNumber &&
                cardSymbol == that.cardSymbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardSymbol);
    }

    @Override
    public String toString(){
        return "" + cardNumber.toString() + " " + cardSymbol.toString();
    }
}
