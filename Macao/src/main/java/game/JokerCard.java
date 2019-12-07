package game;

import utils.enums.CardColor;

/**
 * The type Joker card.
 */
public class JokerCard implements Card {
    private CardColor cardColor;

    /**
     * Instantiates a new Joker card.
     *
     * @param cardColor the card color
     */
    public JokerCard(CardColor cardColor) {
        this.cardColor = cardColor;
    }

    /**
     * Gets card color.
     *
     * @return the card color
     */
    public CardColor getCardColor() {
        return cardColor;
    }

    /**
     * Sets card color.
     *
     * @param cardColor the card color
     */
    public void setCardColor(CardColor cardColor) {
        this.cardColor = cardColor;
    }
}
