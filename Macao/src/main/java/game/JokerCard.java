package game;

import utils.enums.CardColor;

import java.util.Objects;

/**
 * The type Joker card.
 */
public final class JokerCard implements Card {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JokerCard jokerCard = (JokerCard) o;
        return cardColor == jokerCard.cardColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardColor);
    }
}
