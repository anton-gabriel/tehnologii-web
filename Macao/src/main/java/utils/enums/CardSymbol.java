package utils.enums;

import java.util.stream.Stream;

/**
 * The enum Card symbol.
 */
public enum CardSymbol {
    /**
     * Clubs card symbol.
     */
    CLUBS,
    /**
     * Diamonds card symbol.
     */
    DIAMONDS,
    /**
     * Hearts card symbol.
     */
    HEARTS,
    /**
     * Spades card symbol.
     */
    SPADES;

    /**
     * Stream stream.
     *
     * @return the stream
     */
    public static Stream<CardSymbol> stream() {
        return Stream.of(CardSymbol.values());
    }
}
