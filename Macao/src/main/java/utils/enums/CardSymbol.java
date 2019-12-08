package utils.enums;

import java.util.stream.Stream;

/**
 * The enum Card symbol.
 */
public enum CardSymbol {
    /**
     * Clubs card symbol.
     */
    CLUBS(CardColor.BLACK),
    /**
     * Diamonds card symbol.
     */
    DIAMONDS(CardColor.RED),
    /**
     * Hearts card symbol.
     */
    HEARTS(CardColor.RED),
    /**
     * Spades card symbol.
     */
    SPADES(CardColor.BLACK);

    /**
     * The color of the card.
     */
    private CardColor color;

    CardSymbol(CardColor color) {
        this.color = color;
    }

    /**
     * Stream stream.
     *
     * @return the stream
     */
    public static Stream<CardSymbol> stream() {
        return Stream.of(CardSymbol.values());
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public CardColor getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(CardColor color) {
        this.color = color;
    }
}
